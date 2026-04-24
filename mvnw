#!/usr/bin/env sh
# Generated wrapper script for Maven
BASEDIR=$(dirname "$0")
exec java -Dmaven.multiModuleProjectDirectory="$BASEDIR" -cp "$BASEDIR/.mvn/wrapper/maven-wrapper.jar" org.apache.maven.wrapper.MavenWrapperMain "$@"
