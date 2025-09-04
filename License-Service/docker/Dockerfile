FROM openjdk:17
LABEL maintainer="Illary Huaylupo <Illaryhs@gmail.com>"
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]