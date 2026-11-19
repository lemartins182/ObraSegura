# Modelo de Banco de Dados — ObraSegura

## 1. Visão Geral

O ObraSegura utiliza o Oracle Database para armazenar e organizar as informações necessárias ao monitoramento de obras, atividades, sensores, leituras, alertas e usuários.

O modelo de dados foi desenvolvido para permitir o relacionamento entre as diferentes entidades do sistema, garantindo organização, integridade e consistência das informações.

O banco de dados faz parte da arquitetura da aplicação e é acessado pelo backend Java por meio da camada DAO.

---

## 2. Principais Entidades

### EMPRESA

Armazena os dados das empresas responsáveis pelas obras cadastradas no sistema.

Principais informações:
- Identificação da empresa;
- Nome;
- Dados cadastrais.

### OBRA

Representa os empreendimentos monitorados pela plataforma.

Principais informações:
- Identificação da obra;
- Nome;
- Localização;
- Cidade;
- Estado;
- Empresa responsável.

Uma empresa pode possuir diversas obras.

### ATIVIDADE

Representa as atividades executadas dentro de uma obra.

Principais informações:
- Identificação da atividade;
- Nome;
- Descrição;
- Obra relacionada.

Uma obra pode possuir diversas atividades.

### SENSOR

Armazena os dispositivos de monitoramento associados às obras.

Principais informações:
- Identificação do sensor;
- Código;
- Tipo;
- Localização;
- Status;
- Obra relacionada.

Os sensores podem representar diferentes tipos de monitoramento, como sensores ambientais ou sensores de movimento.

### LEITURA_SENSOR

Armazena os dados coletados ou simulados pelos sensores.

Principais informações:
- Identificação da leitura;
- Sensor relacionado;
- Valor;
- Unidade;
- Data e hora;
- Descrição da leitura.

Um sensor pode gerar diversas leituras ao longo do tempo.

### ALERTA

Armazena os alertas gerados pelo sistema a partir da identificação de situações potencialmente anormais.

Principais informações:
- Identificação do alerta;
- Obra relacionada;
- Sensor relacionado;
- Título;
- Descrição;
- Nível de prioridade;
- Status;
- Data e hora.

Os alertas podem ser classificados e acompanhados por profissionais responsáveis.

### USUARIO

Armazena os usuários que utilizam a plataforma.

A estrutura permite representar diferentes perfis de usuários, como trabalhadores, engenheiros e profissionais de segurança.

### RISCO

Representa os riscos ocupacionais identificados nas atividades realizadas nas obras.

Permite relacionar os riscos às atividades e apoiar o gerenciamento preventivo.

### INSPECAO

Armazena informações relacionadas às inspeções de segurança realizadas nas obras.

Permite registrar e acompanhar verificações realizadas pelos responsáveis.

### PARTICIPACAO_ATIVIDADE

Representa o relacionamento entre usuários e atividades, permitindo registrar a participação de usuários nas atividades da obra.

### OCORRENCIA

Representa o registro de ocorrências relacionadas ao ambiente de trabalho e à segurança ocupacional.

---

## 3. Relacionamentos

O modelo de dados possui os seguintes relacionamentos principais:

- Uma empresa pode possuir várias obras;
- Uma obra pode possuir várias atividades;
- Uma obra pode possuir vários sensores;
- Uma atividade pode possuir registros relacionados a riscos;
- Uma atividade pode possuir participações de usuários;
- Um sensor pode gerar várias leituras;
- Um sensor pode estar associado a alertas;
- Uma obra pode possuir vários alertas;
- Uma obra pode possuir inspeções;
- Usuários podem participar de atividades e registrar informações relacionadas à segurança.

---

## 4. Estrutura Relacional

O banco de dados utiliza relacionamentos por meio de chaves primárias e estrangeiras.

As chaves primárias identificam unicamente os registros de cada tabela.

As chaves estrangeiras permitem relacionar registros entre diferentes tabelas, garantindo a integridade referencial.

Exemplos:

- `OBRA` possui relacionamento com `EMPRESA`;
- `ATIVIDADE` possui relacionamento com `OBRA`;
- `SENSOR` possui relacionamento com `OBRA`;
- `LEITURA_SENSOR` possui relacionamento com `SENSOR`;
- `ALERTA` possui relacionamento com `OBRA` e `SENSOR`.

---

## 5. Fluxo dos Dados

O fluxo principal de dados do monitoramento funciona da seguinte forma:

1. Uma obra é cadastrada no sistema;
2. Sensores são associados à obra;
3. Os sensores geram leituras;
4. O backend processa e analisa os eventos;
5. Situações potencialmente anormais podem gerar alertas;
6. Os alertas são armazenados no Oracle Database;
7. O dashboard consulta os dados e apresenta as informações;
8. Um profissional responsável pode verificar o alerta e atualizar seu status.

No protótipo atual, os eventos de movimentação são simulados para demonstrar o funcionamento do sistema.

---

## 6. Tecnologia Utilizada

| Componente | Tecnologia |
|---|---|
| Sistema Gerenciador de Banco de Dados | Oracle Database |
| Linguagem de consulta | SQL |
| Acesso ao banco | JDBC |
| Persistência | DAO |
| Backend | Java 21 |
| Framework | Spring Boot |

---

## 7. Integração com o Backend

A aplicação Java utiliza a camada DAO para realizar operações de acesso ao banco de dados.

Entre as operações realizadas estão:

- Consultar informações das obras;
- Consultar sensores;
- Recuperar leituras;
- Consultar alertas;
- Persistir novos alertas;
- Atualizar o status dos alertas;
- Integrar os dados ao monitoramento apresentado no dashboard.

A separação entre a camada de negócio e a camada de acesso a dados facilita a manutenção e evolução do sistema.

---

## 8. Evolução do Banco de Dados

O modelo foi estruturado para permitir futuras expansões, incluindo:

- Registro de trabalhadores e suas atividades;
- Controle de treinamentos e autorizações;
- Histórico de inspeções;
- Registro de ocorrências;
- Ampliação do monitoramento de sensores;
- Integração com dispositivos IoT;
- Armazenamento de dados provenientes de sensores físicos.

---

## 9. Considerações

O banco de dados é uma parte fundamental do ObraSegura, permitindo centralizar informações relacionadas às obras, atividades, sensores, leituras e alertas.

Sua estrutura contribui para a organização das informações e para o desenvolvimento de uma plataforma de monitoramento e prevenção de riscos ocupacionais.

O protótipo atual utiliza dados cadastrados e eventos simulados para demonstrar o funcionamento da solução.