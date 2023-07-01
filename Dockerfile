FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/clubmvc-0.0.1-SNAPSHOT.jar /app/clubmvc.jar

# Expose the port on which your Spring application is running (default is 8080)
EXPOSE 8080

# Set the entrypoint command to run your Spring application
CMD ["java", "-jar", "clubmvc.jar"]

# Use the official Tomcat 9.0-alpine base image
#FROM tomcat:9.0-alpine

# Remove the existing ROOT application
#RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the WAR file to the webapps directory
#ADD build/libs/clubmvc-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/clubmvc.jar

# Set environment variables (if needed)
# ENV EXAMPLE_VARIABLE value

# Expose the default Tomcat port
#EXPOSE 8080

# Start Tomcat
#CMD ["catalina.sh", "run"]