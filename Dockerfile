FROM openjdk:8-jdk-alpine

EXPOSE 8090

COPY target/autorisationServise-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "app."]