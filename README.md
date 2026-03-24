# 🚀 ZaryxNear Docs

![ZaryxNear Docs](https://zaryxnear.dev/assets/zaryxnear_logo.png)

Official Zaryx Studios repository for Minecraft plugin engineering documentation.

- Production-grade performance
- Clean, modular architecture
- Step-by-step learning paths (Fundamentals, Performance, Architecture, Real Projects, API)

---

## Quick Index

1. app/ - web service + gRPC
2. autogen/ - documentation generator from JAR
3. src/main/resources/docs/minecraft/zaryxnear/ - ZaryxNear primary docs
4. src/main/resources/docs/minecraft/plugins/ - legacy plugin reference

---

## Recommended usage

### Contribute docs

1. Fork
2. Add .md under src/main/resources/docs/minecraft/zaryxnear/
3. Create PR

### Recommended documentation format

```md
# <Title>

## 🧠 Mental Model
Concept overview

## 📦 Java Example
Working code sample

## ⚙️ Internals
How it works under the hood

## ⚠️ Edge Cases
Critical corner cases

## 🔥 Performance Warning
TPS / memory impact

## 💡 Pro Tips
Advanced patterns

## ❓ Why / When / When NOT
When to use and when to avoid
```

---

## Generate docs from JAR

### Full scan

```bash
./mvnw -pl autogen -am exec:java \
  -Dexec.mainClass="dev.zaryxstudios.zaryxnear.autogen.DocGeneratorCLI" \
  -Dexec.args="full"
```

### Package-specific scan

```bash
./mvnw -pl autogen -am exec:java \
  -Dexec.mainClass="dev.zaryxstudios.zaryxnear.autogen.DocGeneratorCLI" \
  -Dexec.args="package com.example.api"
```

### Input / Output

- Input: autogen/src/main/resources/input/
- Output: autogen/src/main/resources/output/

---

## Docker

```bash
docker build -t zaryxnear-docs .
docker run -p 9093:9093 zaryxnear-docs
```

---

## CI/CD

Pipeline defined in .github/workflows/deploy.yml:
- Maven build
- docs generation
- Docker image build
- auto deploy

---

## Contribution rules

✅ Required
- Document real scenarios
- Include performance impact and warnings
- Explain the why behind decisions
- Keep compatibility across versions

❌ Forbidden
- Upload binaries
- Copy docs unchanged from other projects
- Superficial content

---

## ZaryxNear philosophy

"We do not write code just to make it work. We build systems that scale."
## System Requirements and Env Setup

- Java 17+
- Maven 3.8+
- Docker (optional)
- `.env` from `.env.example`

Required environment variables (see `.env.example`):
- `GRPC_SERVER_PORT`
- `GRPC_MAX_MESSAGE_SIZE`
- `DOCS_BASE_PATH`
- `DOCS_CACHE_SIZE`
- `ANTHROPIC_API_KEY`
- `LOG_LEVEL`

## Run locally

```bash
./mvnw clean package -DskipTests
./mvnw -pl app spring-boot:run
```

## gRPC API example

- config in `application.yml`/`application.properties`
- endpoint `localhost:${GRPC_SERVER_PORT}`

## Troubleshooting

- `ResourceNotFound` en docs: coloque .md en `src/main/resources/docs/...`
- `OutOfMemory` al cargar docs grandes: use `MAX_IN_MEMORY_SIZE` en `DocsService`
## Contact

Zaryx Studios
📧 docs@zaryxnear.dev

## Support the project

If this project helps, please:

👉 Star it on GitHub
👉 Share with fellow developers
