FROM openjdk:17

EXPOSE 8081

WORKDIR /app

COPY target/Delivery_service-0.0.1-SNAPSHOT.jar /app/your-app.jar

CMD ["java", "-jar", "your-app.jar"]
