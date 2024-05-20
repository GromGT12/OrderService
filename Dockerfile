# Use a base image with JDK
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/Delivery_service.jar /app/app.jar

# Set the command to run the JAR file
CMD ["java", "-jar", "app.jar"]
