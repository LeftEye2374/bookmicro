

FROM openjdk:17 as build
WORKDIR application
COPY --from=build application/depedencies/ ./
COPY --from=build application/spring-boot-loader/ ./
COPY --from=build application/snapshot-dependencies/ ./
COPY --from=build application/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]