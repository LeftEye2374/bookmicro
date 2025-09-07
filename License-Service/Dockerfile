FROM openjdk:17 AS builder
WORKDIR /application
COPY target/license-service-0.0.1-SNAPSHOT.jar application.jar
RUN java -Djarmode=tools -jar application.jar list-layers
RUN java -Djarmode=tools -jar application.jar extract

FROM openjdk:17
WORKDIR /application
COPY --from=builder /application ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]