# Etapa 1: construir o projeto
FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app

# Copia os arquivos necessários para build
COPY pom.xml .
COPY src ./src

# Compila e empacota a aplicação
RUN mvn clean package -DskipTests

# Etapa 2: criar imagem final
FROM eclipse-temurin:23-jdk
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]
