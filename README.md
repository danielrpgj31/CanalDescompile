# CanalDescompile

Fontes dos tutoriais e treinamentos do Canal Descompile

## NGINX Setup

### Install NGINX 

1. Remove default and prepare environment

```
# remove default nginx
sudo apt remove nginx nginx-common

# update apt repositories
sudo apt update

# install dependencies
sudo apt install build-essential libpcre3 libpcre3-dev zlib1g zlib1g-dev libssl-dev
```

2. Download source code

```
cd /usr/local/src
wget http://nginx.org/download/nginx-<VERSÃO>.tar.gz
tar -xzvf nginx-<VERSÃO>.tar.gz
cd nginx-<VERSÃO>
```

3. Configure desired modules

```
./configure --with-http_limit_req_module --with-http_limit_conn_module --with-http_ssl_module
```

4. Compile and Install

```
make
sudo make install
```

5. Verify install

```
/usr/local/nginx/sbin/nginx -V
```

6. Verify nginx.conf

```
sudo /usr/local/nginx/sbin/nginx -t
```

7. Load nginx

```
sudo /usr/local/nginx/sbin/nginx
```

8. Reload nginx with new conf

```
sudo /usr/local/nginx/sbin/nginx -s reload
```

### Configure app on NGINX as reverse proxy

## Create Java API to Stress

### Criar um projeto Spring Boot

1. Acesse o Spring Initializr

    https://start.spring.io/

2. Configure o projeto:

```
Project: Maven
Language: Java
Spring Boot Version: 3.x.x (Stable)
Dependencies:
Spring Web
Docker Compose (opcional, se for usar docker-compose)
Packaging: Jar
Java Version: 17 (ou conforme sua instalação).
```

3. Clique em "Generate" para baixar o projeto.
4. Extraia o projeto para o seu ambiente de desenvolvimento.

### Implementar a API para teste

1. Abra o projeto em sua IDE favorita (IntelliJ, Eclipse, etc.).

2. No diretório src/main/java/<seu-pacote>, abra o arquivo principal do aplicativo, por exemplo, DemoApplication.java.

3. Crie um controlador para expor a API:

```
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelayController {

    @GetMapping("/simulate-delay")
    public String simulateDelay() throws InterruptedException {
        // Simula um delay de 10 segundos
        Thread.sleep(10000);
        return "Resposta após 10 segundos!";
    }
}
```

### Criar o arquivo application.properties (opcional)

No diretório src/main/resources, configure o servidor na porta desejada, por exemplo, 8080:

```
server.port=8080
```

### Criar o arquivo application.properties (opcional)
No terminal, na raiz do projeto, execute o seguinte comando para construir o JAR:

```
./mvnw clean package
```

### Criar o container Docker

1. No terminal, construa a imagem Docker:

```
docker build -t spring-delay-app .
```

2. Rode o container Docker:

```
docker run -p 8080:8080 spring-delay-app
```

Agora, a API estará acessível em http://localhost:8080/simulate-delay.

### Testar a API

1. Acesse o endpoint em qualquer navegador ou ferramenta como o curl ou Postman:

```
curl http://localhost:8080/simulate-delay
```

Você verá a resposta após 10 segundos:

```
Resposta após 10 segundos!
```