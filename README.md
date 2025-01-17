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

### Configure app on NGINX as reverse proxy

### Create Java App
