# Use a imagem oficial do Maven para compilar o projeto
FROM maven:3.8.4-openjdk-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml e outros arquivos de configuração para o diretório de trabalho
COPY pom.xml .

# Baixa as dependências do projeto (somente as dependências, sem compilar o código-fonte ainda)
RUN mvn dependency:go-offline

# Copia o código-fonte do projeto para o diretório de trabalho
COPY src ./src

# Compila o projeto e gera o arquivo JAR
RUN mvn clean package -DskipTests

# Usa uma imagem menor do JDK 17 para rodar a aplicação
FROM openjdk:17-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado no estágio anterior para o diretório de trabalho
COPY --from=build /app/target/*.jar app.jar

# Define a porta que a aplicação irá expor
EXPOSE 8080

# Define o comando padrão para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
