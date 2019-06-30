FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/tp01-0.0.1-SNAPSHOT.jar
ADD ${DEPENDENCY} tp01.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tp01.jar"]
