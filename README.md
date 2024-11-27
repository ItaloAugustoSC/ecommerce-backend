**Projeto:** Plataforma de E-commerce na Nuvem

**Descrição**

O projeto é um backend para uma plataforma de e-commerce moderna e escalável. 
Ele oferece APIs RESTful para gerenciar produtos, categorias, usuários, pedidos 
e pagamentos, utilizando a infraestrutura da AWS para garantir alta disponibilidade, 
segurança e desempenho.

**Funcionalidades**
1. Cadastro e Autenticação de Usuários
   - Registro e login de usuários via AWS Cognito com suporte a autenticação via redes sociais.
   - Perfis de usuários: Cliente e Administrador.
     - Regras:
     Apenas administradores podem criar, editar ou excluir produtos e categorias.
2. Gerenciamento de Produtos e Categorias
   - CRUD de produtos e categorias.
   - Upload de imagens dos produtos usando AWS S3.
     - Regras:
     Produtos podem estar ativos ou inativos. Somente produtos ativos aparecem na loja.
3. Carrinho de Compras
   - Adicionar/remover produtos no carrinho.
   - Visualizar resumo do carrinho, incluindo valores totais e descontos aplicados.
4. Gestão de Pedidos
   - Criar pedidos a partir do carrinho.
   - Atualizar status do pedido (Pendente, Pago, Enviado, Concluído, Cancelado).
   - Enviar notificações para o cliente sobre atualizações do pedido via AWS SNS.
     - Regras:
     Pedidos só podem ser cancelados se ainda não estiverem no status "Enviado".
5. Pagamentos
   - Integração com provedores de pagamento usando AWS Lambda para processar pagamentos.
   - Registro de histórico de transações no AWS RDS.
     - Regras:
     Pedidos só mudam para "Pago" após confirmação do provedor de pagamento.
6. Relatórios de Vendas
   - Análise de vendas usando AWS Athena para consultas em logs no S3.
   - Relatórios de desempenho para administradores.
7. Monitoramento e Logs
   - Registro de logs com AWS CloudWatch.
   - Notificação de falhas críticas via AWS CloudWatch Alarms.

Diagrama
```
                         +---------------------------+
                         |      AWS API Gateway      |
                         +-------------+-------------+
                                       |
                                       v
                     +----------------------------------+
                     |          AWS Cognito            |
                     | (Autenticação e Autorização)    |
                     +----------------------------------+
                                       |
                                       v
     +-----------------------------------------+----------------+
     |                                         |                |
     v                                         v                v
+------------------+              +------------------+  +------------------+
| Product Service  |              | Order Service    |  | Payment Service  |
| (Spring Boot,    |              | (Spring Boot,    |  | (AWS Lambda)     |
| ECS + RDS)       |              | ECS + RDS)       |  +------------------+
+------------------+              +------------------+          |
|                                |                       |
v                                v                       v
+------------------+              +------------------+   +------------------+
|  AWS S3         |              | AWS SNS          |   |  AWS RDS         |
| (Imagens de     |              | (Notificações)   |   | (Histórico de    |
| Produtos)       |              +------------------+   | Pagamentos)      |
+------------------+                                     +------------------+
|
v
+------------------+
| AWS Athena       |
| (Relatórios de   |
| Vendas)          |
+------------------+

                         +---------------------------+
                         |   AWS CloudWatch          |
                         | (Logs e Monitoramento)    |
                         +---------------------------+
```

**Descrição dos Componentes**

1. AWS API Gateway

- Roteia as requisições para os microserviços.
- Gerencia throttling e autenticação.

2. AWS Cognito

- Gerencia autenticação e autorização com suporte a federated identity.

3. Product Service

- CRUD de produtos e categorias.
- Armazena imagens no AWS S3.

4. Order Service

- Gerencia carrinhos, pedidos e status de pedidos.
- Publica notificações via AWS SNS.

5. Payment Service

- Processa pagamentos com funções serverless em AWS Lambda.
- Integra-se com provedores de pagamento externos.

6. AWS S3

- Armazena imagens de produtos e logs de transações.

7. AWS RDS

- Base de dados relacional para produtos, usuários e pedidos.

8. AWS SNS

- Envia notificações sobre atualizações de pedidos.

9. AWS Athena

- Analisa dados de vendas e gera relatórios para administradores.

10. AWS CloudWatch

- Monitora logs e métricas de toda a aplicação.