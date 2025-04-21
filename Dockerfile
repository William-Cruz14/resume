FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
LABEL authors="william"
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests


# Copiar o arquivo JAR para o container
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /home/app/target/*.jar /app.jar

# Executar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]