FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY *.jar microapi.jar
ENTRYPOINT ["java","-jar","/microapi.jar"]