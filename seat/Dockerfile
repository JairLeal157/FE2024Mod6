# Etapa de construcción
FROM maven:3.8.5-openjdk-17 AS build

# Copia el código fuente al contenedor
COPY . .

# Compila y empaqueta la aplicación utilizando Maven (se omiten las pruebas)
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17.0.1-jdk-slim

# Copia el archivo JAR compilado desde la etapa de construcción al contenedor
COPY --from=build /target/*.jar app.jar

# Expone el puerto en el que tu aplicación Spring Boot se ejecuta
EXPOSE 8080

# Opcional: Configuración para mostrar los logs en la consola de Docker
RUN ln -sf /dev/stdout /var/log/app.log

# Comando para ejecutar tu aplicación Spring Boot cuando el contenedor se inicie
ENTRYPOINT ["java", "-jar", "app.jar"]
