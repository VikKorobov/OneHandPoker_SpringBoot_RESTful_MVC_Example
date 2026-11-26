# ---------- Build ----------
FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

# Copy the Maven Wrapper and project configuration
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Normalize line endings and make the Maven Wrapper executable
RUN sed -i 's/\r$//' mvnw && chmod +x mvnw

# Cache dependencies separately from source code
RUN ./mvnw dependency:go-offline -B

# Copy source code and build inside Docker
COPY src/ src/
RUN ./mvnw clean package -B -DskipTests

# ---------- Runtime ----------
FROM eclipse-temurin:25-jre

WORKDIR /app

# Copy only the compiled application
COPY --from=build /app/target/*.jar app.jar

# Expose the REST API
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]