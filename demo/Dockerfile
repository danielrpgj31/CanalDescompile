# Usar a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Criar o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado para o container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]
