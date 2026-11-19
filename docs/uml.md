# UML — Diagrama de Classes do ObraSegura

## 1. Visão Geral

O diagrama de classes do ObraSegura representa a estrutura orientada a objetos do sistema, demonstrando as principais entidades, suas responsabilidades, atributos e relacionamentos.

O projeto utiliza conceitos de Programação Orientada a Objetos (POO), como:

- Encapsulamento
- Herança
- Abstração
- Polimorfismo

## 2. Diagrama de Classes

```mermaid
classDiagram

    class Usuario {
        <<abstract>>
        -Long id
        -String nome
        -String email
        -String senha
        +getDados()
    }

    class Trabalhador {
        -String cargo
        -String especialidade
    }

    class Engenheiro {
        -String registroProfissional
    }

    class TecnicoSeguranca {
        -String registro
    }

    class Empresa {
        -Long id
        -String nome
        -String cnpj
    }

    class Obra {
        -Long id
        -String nome
        -String endereco
        -String cidade
        -String estado
        -String status
    }

    class Atividade {
        -Long id
        -String nome
        -String descricao
        -String status
    }

    class ParticipacaoAtividade {
        -Long id
        -String funcao
        -String status
    }

    class Risco {
        -Long id
        -String descricao
        -String nivel
        -String categoria
    }

    class Inspecao {
        -Long id
        -String descricao
        -String resultado
        -LocalDate data
    }

    class Sensor {
        <<abstract>>
        -Long id
        -String codigo
        -String tipo
        -String localizacao
        -String status
    }

    class SensorAmbiental {
        -Double temperatura
        -Double umidade
    }

    class SensorMovimento {
        -Double limiteMinimo
        -Double limiteMaximo
    }

    class LeituraSensor {
        -Long id
        -Double valor
        -String unidade
        -LocalDateTime dataHora
    }

    class Alerta {
        -Long id
        -String titulo
        -String descricao
        -String nivel
        -String status
        -LocalDateTime dataHora
    }

    Usuario <|-- Trabalhador
    Usuario <|-- Engenheiro
    Usuario <|-- TecnicoSeguranca

    Sensor <|-- SensorAmbiental
    Sensor <|-- SensorMovimento

    Empresa "1" --> "*" Obra : possui
    Obra "1" --> "*" Atividade : possui
    Atividade "1" --> "*" ParticipacaoAtividade : possui
    Trabalhador "1" --> "*" ParticipacaoAtividade : participa

    Atividade "1" --> "*" Risco : possui
    Obra "1" --> "*" Inspecao : recebe

    Obra "1" --> "*" Sensor : possui
    Sensor "1" --> "*" LeituraSensor : registra
    Sensor "1" --> "*" Alerta : gera
    Obra "1" --> "*" Alerta : possui
```

## 3. Relacionamentos

### Usuários

A classe `Usuario` é abstrata e serve como base para diferentes perfis do sistema:

- `Trabalhador`
- `Engenheiro`
- `TecnicoSeguranca`

Essa estrutura permite compartilhar características comuns e especializar os usuários conforme suas responsabilidades.

### Empresas e Obras

Uma empresa pode possuir várias obras, enquanto cada obra está vinculada a uma empresa.

### Obras e Atividades

Uma obra pode possuir diversas atividades, permitindo organizar e monitorar as tarefas executadas no canteiro.

### Atividades, Trabalhadores e Participações

A classe `ParticipacaoAtividade` representa a relação entre trabalhadores e atividades, permitindo registrar a participação e função desempenhada.

### Atividades e Riscos

Cada atividade pode apresentar diferentes riscos ocupacionais, que podem ser identificados e classificados.

### Obras e Inspeções

As inspeções são associadas às obras, permitindo registrar verificações de segurança e seus resultados.

### Sensores

A classe `Sensor` é abstrata e possui especializações:

- `SensorAmbiental`
- `SensorMovimento`

Os sensores estão vinculados às obras e podem registrar leituras.

### Leituras e Alertas

Os sensores registram leituras por meio da classe `LeituraSensor`.

Quando uma situação potencialmente anormal é identificada, o sistema pode gerar um `Alerta`, associado ao sensor e à obra.

## 4. Aplicação dos Conceitos de POO

| Conceito | Aplicação no ObraSegura |
|---|---|
| Abstração | Classes `Usuario` e `Sensor` |
| Herança | Especializações de `Usuario` e `Sensor` |
| Encapsulamento | A