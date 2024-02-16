FROM openjdk:21-jdk-slim
ARG JAR_FILE=infra/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]