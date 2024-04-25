#Dockerfile

FROM openjdk:21-jdk
CMD ["gradle", "clean", "build"]
VOLUME /tmp
ARG JAR_FILE=build/libs/deploy-sample-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} deploy-sample-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","deploy-sample-0.0.1-SNAPSHOT.jar"]