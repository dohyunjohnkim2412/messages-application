# Build application using Maven
FROM maven:3.9.9-eclipse-temurin-22 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and the source code to the container
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Run application using JRE image
FROM eclipse-temurin:22

# Set the working directory in the container
WORKDIR /app

# Copy JAR file from build to runtime
COPY --from=build /app/target/messages-0.0.1.jar app.jar

# Expose port 8080
EXPOSE 8080

# Set command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]