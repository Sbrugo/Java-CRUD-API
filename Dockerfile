FROM openjdk:17-jdk-slim

# Copy the JAR file into the container
COPY target/JavaRestAPI-Crud.jar app-v2.jar

# Expose port 80
EXPOSE 8080

# Define the entry point to run your application
ENTRYPOINT [“java”, “-jar”, “app-v2.jar”]