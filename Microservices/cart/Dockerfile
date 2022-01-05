FROM openjdk:17-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENV JAVA_OPTS="
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

#FROM openjdk:17
#COPY . /usr/src/myapp
#WORKDIR /usr/src/myapp
#RUN javac Main.java
#CMD ["java", "Main"]

