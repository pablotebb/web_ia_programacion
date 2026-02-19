# ---------- ETAPA 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Al estar el Root Directory bien puesto, esto funcionará:
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# ---------- ETAPA 2: Runtime ----------
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copiamos el jar (Maven lo deja en target/)
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
