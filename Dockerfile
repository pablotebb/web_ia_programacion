# Imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiamos el jar generado
COPY target/*.jar app.jar

# Exponemos el puerto que Render necesita
EXPOSE 8080

# Ejecutamos la aplicación
ENTRYPOINT ["java","-jar","app.jar"]
