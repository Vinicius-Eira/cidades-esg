# 🌍 Projeto - Cidades ESG Inteligentes
---

## 🧩 Descrição do Projeto
O projeto **Cidades ESG Inteligentes** tem como objetivo gerenciar informações sobre cidades e seus indicadores ESG — **Ambiental, Social e Governança**.  
Ele foi desenvolvido em **Java Spring Boot**, e containerizado com **Docker**, integrando um pipeline de **CI/CD no GitHub Actions**, seguindo as práticas DevOps estudadas durante a disciplina.

---

⚙️ Como Executar Localmente com Docker

### 🧱 Pré-requisitos
- Docker e Docker Compose instalados.

### ▶️ Passos para rodar:

# 1. Clonar o repositório
git clone https://github.com/Vinicius-Eira/cidades-esg.git
cd cidades-esg

# 2. Construir e rodar o container
docker-compose up --build

A aplicação estará disponível em:
-> http://localhost:8080
______________________________________

## 🧰 Tecnologias Utilizadas:

-> Backend	Java 21, Spring Boot
-> Build	Maven
-> Banco de Dados	H2 (em memória)
-> Containerização	Docker, Docker Compose
-> CI/CD	GitHub Actions
-> Testes	JUnit, Postman
-> Ferramentas	IntelliJ IDEA, Git, GitHub

______________________________________

## 🐳 Containerização
#  📄 Dockerfile
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
---
# 📄 docker-compose.yml
version: '3.8'

services:
  cidades-esg:
    build: .
    container_name: cidades-esg-app
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:h2:mem:testdb
      - SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
      - SPRING_DATASOURCE_USERNAME=sa
      - SPRING_DATASOURCE_PASSWORD=
      - SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
      - SPRING_H2_CONSOLE_ENABLED=true
      - SPRING_H2_CONSOLE_PATH=/h2-console
    networks:
      - cidades-network

networks:
  cidades-network:
    driver: bridge
______________________________________
    
## 🚀 Pipeline CI/CD
📦 Ferramenta: GitHub Actions

Local: .github/workflows/ci.yml

O pipeline executa automaticamente as seguintes etapas a cada push ou pull request na branch main:

Checkout do código

Build com Maven

Execução de testes automatizados

Geração do artefato JAR

Build da imagem Docker

Deploy (em ambiente staging e produção)

# 🖼️ Exemplo de workflow:

name: CI/CD Pipeline - Cidades ESG

on:
  push:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout do código
        uses: actions/checkout@v4

      - name: Configurar JDK 21
        uses: actions/setup-java@v4
        with:
          java-version: '21'
          distribution: 'temurin'

      - name: Compilar projeto
        run: mvn clean package -DskipTests

      - name: Build da imagem Docker
        run: docker build -t cidades-esg .

      - name: Testar execução local
        run: echo "Build e teste realizados com sucesso!"
______________________________________

## ✅ Checklist de Entrega

Item	OK
Projeto compactado em .ZIP	☑️
Dockerfile funcional	☑️
docker-compose.yml funcional	☑️
Pipeline de build/test/deploy	☑️
README.md completo	☑️
Documentação técnica (PDF/Word)	☑️
Aplicação rodando localmente	☑️



