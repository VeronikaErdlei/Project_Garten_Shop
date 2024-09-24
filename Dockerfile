FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/Project_Garten_Shop-0.0.1-SNAPSHOT.jar /app/Project_Garten_Shop-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/ffapp/Project_Garten_Shop-0.0.1-SNAPSHOT.jar"]