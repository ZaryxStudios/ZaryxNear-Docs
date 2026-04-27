FROM maven:3.9.14-eclipse-temurin-25 AS builder
WORKDIR /app

COPY pom.xml .
COPY app/pom.xml ./app/
COPY autogen/pom.xml ./autogen/
COPY .mvn .mvn
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd
COPY app/src ./app/src
COPY autogen/src ./autogen/src

RUN chmod +x ./mvnw

RUN ./mvnw -pl app,autogen -am -DskipTests clean package

FROM eclipse-temurin:17-jre
WORKDIR /app

RUN groupadd -g 1001 appuser && useradd -u 1001 -g appuser appuser

COPY --from=builder --chown=appuser:appuser app/target/*.jar app.jar

USER appuser

EXPOSE 9093

HEALTHCHECK --interval=30s --timeout=5s --start-period=30s --retries=3 \
  CMD bash -c '</dev/tcp/localhost/9093' || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
