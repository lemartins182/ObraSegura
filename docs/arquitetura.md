# Arquitetura do Sistema — ObraSegura

## 1. Visão Geral

O ObraSegura utiliza uma arquitetura em camadas para organizar as responsabilidades do sistema, facilitar a manutenção e permitir futuras expansões.

O sistema é composto por uma interface web, uma API REST desenvolvida em Java com Spring Boot, uma camada de serviços responsável pelas regras de negócio, uma camada de acesso a dados e um banco de dados Oracle.

## 2. Arquitetura em Camadas

### Frontend
Responsável pela interface de interação com o usuário.

Tecnologias:
- HTML5
- CSS3
- JavaScript
- Chart.js

Responsabilidades:
- Exibir informações das obras;
- Apresentar indicadores de monitoramento;
- Exibir sensores, leituras e alertas;
- Permitir a visualização e verificação de alertas;
- Solicitar simulações de eventos.

### API REST — Backend

Desenvolvida utilizando Java 21 e Spring Boot.

Responsável por receber as requisições HTTP do frontend e encaminhá-las para as camadas responsáveis pelo processamento.

Principais controllers:
- MonitoramentoController
- AlertaController
- SimulacaoController
- StatusController

### Camada Service

Responsável pelas regras de negócio e processamento das informações.

Principais responsabilidades:
- Analisar eventos provenientes dos sensores;
- Identificar situações potencialmente anormais;
- Gerar alertas;
- Gerenciar o fluxo de monitoramento.

### Camada DAO

Responsável pela comunicação com o banco de dados Oracle.

Principais responsabilidades:
- Consultar dados;
- Persistir alertas;
- Recuperar informações de monitoramento;
- Atualizar o status dos alertas.

### Banco de Dados

O projeto utiliza Oracle Database para armazenamento das informações relacionadas a:

- Empresas;
- Obras;
- Atividades;
- Sensores;
- Leituras de sensores;
- Alertas;
- Usuários.

## 3. Fluxo de Funcionamento

1. O usuário acessa o dashboard web.
2. O frontend solicita informações à API REST.
3. Os Controllers recebem e direcionam as requisições.
4. A camada Service executa as regras de negócio.
5. A camada DAO consulta ou modifica os dados no Oracle.
6. Os resultados retornam ao frontend.
7. O dashboard atualiza os indicadores e informações apresentadas.

## 4. Monitoramento e Alertas

No protótipo atual, eventos de movimentação anormal podem ser simulados.

Quando um evento é identificado:

1. O sistema recebe o evento;
2. A camada de serviço analisa a situação;
3. Um alerta é gerado;
4. O alerta é armazenado no banco de dados;
5. O dashboard apresenta o alerta;
6. Um profissional responsável pode realizar a verificação humana e atualizar o status.

O sistema atua como ferramenta de apoio à identificação de riscos, não substituindo inspeções, treinamentos, equipamentos de proteção ou a avaliação dos profissionais responsáveis.

## 5. Evolução da Arquitetura

A arquitetura foi planejada para permitir futuras integrações com dispositivos IoT, como ESP32 e sensores físicos, utilizando protocolos como MQTT.

Essa integração permitirá a transmissão de dados reais para o backend, ampliando as capacidades de monitoramento contínuo.

**Observação:** a integração física com sensores e MQTT representa uma evolução futura do projeto. No protótipo apresentado, os eventos são simulados.

## 6. Tecnologias Utilizadas

| Componente | Tecnologia |
|---|---|
| Frontend | HTML, CSS e JavaScript |
| Backend | Java 21 |
| Framework | Spring Boot |
| API | REST |
| Banco de Dados | Oracle Database |
| Persistência | JDBC / DAO |
| Monitoramento | Simulação de eventos |
| Visualização | Dashboard Web |
