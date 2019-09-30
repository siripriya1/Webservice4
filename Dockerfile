FROM openjdk:8-jdk-alpine
WORKDIR / 
ADD target/webservice4-0.0.1-SNAPSHOT.jar .
EXPOSE 80
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${ENVIRONMENT}","webservice4-0.0.1-SNAPSHOT.jar"]