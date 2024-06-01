#!/bin/bash

# URL do Kong Admin
KONG_ADMIN_URL=http://localhost:8001

# Adiciona um serviço
curl -i -X POST $KONG_ADMIN_URL/services/ \
  --data name=pedidos \
  --data url='http://localhost:8080'

# Captura o ID do serviço criado
SERVICE_ID=$(curl -s $KONG_ADMIN_URL/services/pedidos | jq -r '.id')

# Adiciona uma rota ao serviço
curl -i -X POST $KONG_ADMIN_URL/routes/ \
  --data 'paths[]=/order' \
  --data "service.id=$SERVICE_ID"

# Adiciona um cliente (consumidor)
curl -i -X POST $KONG_ADMIN_URL/consumers/ \
  --data username=ronisvonn

# Adiciona uma credencial ao cliente (exemplo: chave de API)
curl -i -X POST $KONG_ADMIN_URL/consumers/ronisvonn/key-auth/ \
  --data key=api12345678

echo "Configuração do Kong concluída!"
