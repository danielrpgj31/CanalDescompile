#!/bin/bash

API_URL="http://localhost:7001/simulate-delay"  # Substitua pelo endpoint desejado
INTERVAL=2  # Intervalo entre requisições (segundos)

# Variáveis de controle
total_requests=0
success_count=0
error_count=0
total_time=0
start_time=$(date +%s)

clear
echo "🚀 Iniciando teste de carga na API: $API_URL"
echo "--------------------------------------------"

while true; do
    # Mede o tempo da requisição
    start_req=$(date +%s%N)
    response=$(curl -s -o /dev/null -w "%{http_code} %{time_total}" "$API_URL")
    end_req=$(date +%s%N)

    # Captura código HTTP e tempo de resposta
    http_code=$(echo "$response" | awk '{print $1}')
    response_time=$(echo "$response" | awk '{print $2}')
    
    # Atualiza contadores
    ((total_requests++))
    total_time=$(echo "$total_time + $response_time" | bc)

    if [[ $http_code -ge 200 && $http_code -lt 400 ]]; then
        ((success_count++))
    else
        ((error_count++))
    fi

    # Calcula estatísticas
    avg_response_time=$(echo "scale=3; $total_time / $total_requests" | bc)
    success_rate=$(echo "scale=2; ($success_count / $total_requests) * 100" | bc)
    error_rate=$(echo "scale=2; ($error_count / $total_requests) * 100" | bc)

    elapsed_time=$(( $(date +%s) - start_time ))
    rps=$(echo "scale=2; $total_requests / $elapsed_time" | bc)

    # Exibe estatísticas
    clear
    echo "🚀 Testando API: $API_URL"
    echo "--------------------------------------------"
    echo "📊 Total de requisições: $total_requests"
    echo "✅ Sucesso: $success_count ($success_rate%)"
    echo "❌ Erros: $error_count ($error_rate%)"
    echo "⏳ Tempo médio de resposta: ${avg_response_time}s"
    echo "⚡ Requisições por segundo: $rps"
    echo "--------------------------------------------"

    sleep $INTERVAL
done
