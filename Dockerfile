FROM tomcat:latest

EXPOSE 8080

COPY ./build/libs/clubmvc-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "clubmvc-0.0.1-SNAPSHOT.jar"]