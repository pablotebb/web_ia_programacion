# ---------- ETAPA 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Definimos el directorio de trabajo dentro del contenedor
WORKDIR /app

# 1. Copiamos TODO el contenido del Root Directory (ia-programacion-web) al contenedor
# Esto incluye pom.xml y la carpeta src de un solo golpe
COPY . .

# 2. Compilamos el proyecto
# Usamos 'mvn' para generar el archivo .jar
RUN mvn clean package -DskipTests


# ---------- ETAPA 2: Runtime ----------
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# 3. Copiamos el jar generado. 
# Importante: Asegúrate de que el nombre del JAR coincide con lo que genera tu pom.xml
COPY --from=build /app/target/*.jar app.jar

# Render suele usar el puerto que le indiques, pero por defecto Spring usa 8080
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
