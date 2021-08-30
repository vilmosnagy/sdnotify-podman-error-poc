FROM openjdk:11-jre

WORKDIR /app

ARG JAR_FILE
ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-jar", "/app/cli.jar"]
ADD target/sdnotify-systemd-demo-0.0.1-SNAPSHOT.jar /app/cli.jar
