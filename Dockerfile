FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/BankSystemFromJavaAcademy-0.0.1-SNAPSHOT.jar app.jar

EXPOSE ${DOCKER_PORT:-8080}

ENTRYPOINT ["java", "-jar", "app.jar"]