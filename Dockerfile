# Use official OpenJDK
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy Maven-built jar (if you build locally)
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
