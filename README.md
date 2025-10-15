# 🌎 Projeto Cidades ESG Inteligentes  

## 🧠 Sobre o Projeto  

O **Cidades ESG Inteligentes** é uma aplicação desenvolvida em **Java Spring Boot**, com o objetivo de promover o monitoramento e gestão de indicadores de sustentabilidade (ESG) em cidades brasileiras.  
O projeto integra práticas de **DevOps**, com pipeline automatizado, containerização via **Docker** e orquestração com **Docker Compose**, simulando um ambiente de produção real.

---

## 👥 Equipe  

| Nome | E-mail |
|------|--------|
| Vinícius Ribeiro dos Santos Eira | viniciusantos.eira@gmail.com |
| William Dias Lima | wdlima@gmail.com |
| Renan Dorneles Barboza Boucault | renandornelesboucault@gmail.com |
| Carlos Eduardo Silva Dias | dudu.hjcd@gmail.com |
| Marcelo Guimarães dos Santos | marceloguimaraesdev@gmail.com |

**Organização:** FIAP  
**Curso:** Engenharia de Software  
**Fase:** Navegando pelo Mundo DevOps  

---

## 🐳 Como Executar Localmente com Docker  

### 🔧 Pré-requisitos  
- Docker e Docker Compose instalados  
- Git instalado  

### ▶️ Passos para execução  

1. Clone o repositório:
   ```bash
   git clone https://github.com/Vinicius-Eira/cidades-esg.git
   cd cidades-esg

2. Construa e suba os containers:
   ```bash
   docker-compose up --build

3. Acesse a aplicação:
🌐 http://localhost:8080

Acesse o banco de dados H2:
🌐 http://localhost:8080/h2-console

  JDBC URL: jdbc:h2:mem:testdb

  Usuário: sa

  Senha: (em branco)

_________________________________

##⚙️ Pipeline CI/CD

O pipeline foi configurado com GitHub Actions, automatizando as seguintes etapas:

Build — Compila o projeto e gera o artefato .jar

Testes — Executa os testes automatizados do projeto

Docker Build & Push — Gera e publica a imagem Docker

Deploy — Realiza o deploy automatizado para os ambientes staging e produção

🧩 Estrutura do workflow
Local: .github/workflows/ci-cd.yml
   ```bash
  name: CI/CD - Cidades ESG

  on:
    push:
      branches: [ main ]

  jobs:
    build:
      runs-on: ubuntu-latest
      steps:
       - uses: actions/checkout@v3
       - name: Configurar JDK
         uses: actions/setup-java@v3
         with:
          java-version: '21'
          distribution: 'temurin'
      - name: Build com Maven
        run: mvn clean package -DskipTests
      - name: Construir imagem Docker
        run: docker build -t cidades-esg .

_________________________________
## 🐋 Containerização
