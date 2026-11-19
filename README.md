# 🏗️ ObraSegura

**Tecnologia que antecipa riscos. Inteligência que protege vidas.**

Sistema de monitoramento e prevenção de riscos ocupacionais na construção civil, desenvolvido como projeto da **FIAP Global Solution 2026**.

## 📌 Sobre o projeto

A construção civil apresenta diversos riscos ocupacionais que podem resultar em acidentes e comprometer a segurança dos trabalhadores.

O **ObraSegura** propõe uma solução tecnológica para auxiliar profissionais de segurança e engenharia no monitoramento de obras, identificação de situações potencialmente perigosas e gerenciamento de alertas.

A plataforma reúne informações sobre obras, atividades, sensores, leituras e alertas em um dashboard centralizado, permitindo uma resposta mais rápida às situações que exigem atenção.

## 🎯 Objetivo

Contribuir para a prevenção de acidentes de trabalho na construção civil por meio da tecnologia, monitoramento e análise de eventos potencialmente perigosos.

## 🚀 Funcionalidades implementadas

- Dashboard de monitoramento de obras
- Visualização de obras, atividades e sensores
- Monitoramento de leituras de sensores
- Geração de alertas a partir de eventos simulados
- Identificação de alertas pendentes de verificação
- Verificação e atualização do status de alertas
- Atualização automática do dashboard
- API REST para comunicação entre frontend e backend
- Persistência de dados utilizando Oracle Database

## 🖥️ Tecnologias utilizadas

### Backend
- Java 21
- Spring Boot
- Spring Web
- Maven
- JDBC

### Banco de dados
- Oracle Database
- Oracle JDBC Driver

### Frontend
- HTML5
- CSS3
- JavaScript
- Chart.js

### Ferramentas
- IntelliJ IDEA
- Git
- GitHub
- Oracle SQL Developer

## 🏛️ Arquitetura

O projeto utiliza uma arquitetura em camadas:

```text
Frontend
HTML + CSS + JavaScript
        │
        ▼
API REST
Spring Boot Controllers
        │
        ▼
Services
Regras de negócio e análise
        │
        ▼
DAO
Persistência e consultas
        │
        ▼
Oracle Database
```

## 📊 Monitoramento e alertas

O protótipo permite simular eventos de movimentação anormal associados a sensores.

Quando um evento é identificado, o sistema gera um alerta para análise e verificação humana.

**O sistema não substitui equipamentos de proteção, procedimentos de segurança, inspeções técnicas ou profissionais habilitados.**

## 🔌 API REST

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/monitoramento` | Consulta os dados do monitoramento |
| POST | `/api/simulacao/movimento` | Simula um evento de movimentação |
| PUT | `/api/alertas/{id}/verificar` | Verifica um alerta |

## 🗄️ Banco de dados

O sistema utiliza Oracle Database para persistência de informações relacionadas a:

- Empresas
- Obras
- Atividades
- Sensores
- Leituras de sensores
- Alertas
- Usuários

## ▶️ Como executar

### Pré-requisitos

- Java 21
- Maven
- Oracle Database
- IntelliJ IDEA ou outra IDE compatível

### Configuração do banco de dados

Configure as variáveis de ambiente utilizadas para conexão com o Oracle:

```text
ORACLE_USER
ORACLE_PASSWORD
```

Não compartilhe ou publique suas credenciais de banco de dados.

### Executando a aplicação

1. Clone o repositório:

```bash
git clone https://github.com/lemartins182/ObraSegura.git
```

2. Abra o projeto na IDE.

3. Configure as variáveis de ambiente de conexão com o Oracle.

4. Execute a classe principal:

```text
ObraSeguraApplication
```

5. Acesse o dashboard:

```text
http://localhost:8080
```

## 🌱 Evoluções futuras

- Integração física com sensores IoT
- Comunicação utilizando MQTT
- Integração com dispositivos ESP32
- Monitoramento de condições ambientais
- Aplicativo mobile para trabalhadores
- Checklists de segurança antes das atividades
- Registro de condições inseguras com fotografias
- Integração com indicadores e dados de acidentes
- Análise inteligente de riscos
- Expansão dos relatórios gerenciais

## 🌍 Objetivos de Desenvolvimento Sustentável

O projeto está alinhado principalmente ao:

**ODS 8 — Trabalho Decente e Crescimento Econômico**

Meta relacionada: proteção dos direitos trabalhistas e promoção de ambientes de trabalho seguros.

Também possui relação com:

- ODS 3 — Saúde e Bem-Estar
- ODS 9 — Indústria, Inovação e Infraestrutura

## 🎓 Projeto acadêmico

Desenvolvido para a **FIAP Global Solution 2026**.

**ObraSegura — Tecnologia que antecipa riscos. Inteligência que protege vidas.**
---

## 📚 Documentação

- [Arquitetura do Sistema](docs/arquitetura.md)
- [Diagrama UML](docs/uml.md)
- [Modelo do Banco de Dados](docs/modelo-banco.md)

---