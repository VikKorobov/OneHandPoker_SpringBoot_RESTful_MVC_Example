
# ---------- Build ----------
FROM maven:3.9-eclipse-temurin-25 AS build

WORKDIR /app

# Cache dependencies separately from source code
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build inside Docker
COPY src ./src
RUN mvn clean package -B -DskipTests

# ---------- Runtime ----------
FROM eclipse-temurin:25-jre

WORKDIR /app

# Copy only the compiled application
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
