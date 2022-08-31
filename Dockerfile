FROM openjdk:8
EXPOSE 8080
ADD target/library-0.0.1-SNAPSHOT.jar vmts.jar
ENTRYPOINT ["java","-jar","vmts.jar"]