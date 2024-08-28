FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=mysql","-jar","/app.jar"]