FROM adoptopenjdk:16_36-jre-hotspot as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract


FROM adoptopenjdk:16_36-jre-hotspot
WORKDIR application
COPY --from=builder application/dependecies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependecies/ ./
COPY --from=builder application/application/ ./

EXPOSE 8081

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]