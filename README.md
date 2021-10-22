# Vehicontrol

Vehicontrol é uma api para controle de veículos que consome a api da tabela FIPE (https://deividfortuna.github.io/fipe) para fornecer informações de preço e rodízio aos usuários.

Este projeto foi desenvolvido como um desafio técnico na minha participação do processo seletivo no programa Orange Talents da Zup Innovation. O objetivo era escrever um post blog explicando de maneira detalhada ("para alguém que não manja tanto de programação") como seria a implementação do projeto. O texto pode ser lido [aqui](https://medium.com/@wandersonbezerralima/construindo-uma-api-rest-para-controle-de-ve%C3%ADculos-com-spring-e16abb967fdf).

## Tecnologias

- Java 11
- Spring Boot
- Spring Web
- Spring Data JPA (Spring Data + Hibernate)
- Bean Validation
- PostgreSQL Driver
- OpenFiegn
- ModelMapper
- Maven
- PostgreSQL

## Endpoints

### Cadastrando um usuário:
````
POST /api/usuarios
````
- **Exemplo Payload Request**
~~~json
{
    "nome": "Ayrton Senna",
    "email": "senninha@email.com",
    "cpf": "58306493060",
    "dataNascimento": "1960-03-21"
}
~~~
  
- **Exemplo Payload Response**
~~~json
 {
    "id": 1,
    "nome": "Ayrton Senna",
    "email": "senninha@email.com",
    "cpf": "58306493060",
    "dataNascimento": "1960-03-21"
}
~~~
___
### Cadastrando um veículo de um usuário:

``` 
POST /api/veiculos
```
- **Exemplo Payload Request**
~~~json
{
    "usuario": {
        "id": 1
    },
    "tipoVeiculo":"CARRO",
    "marca":"Fiat",
    "modelo":"Palio 1.6 mpi 16V 4p",
    "combustivel": "GASOLINA",
    "ano": 1997
}
~~~

- **Exemplo Payload Response**

~~~json
{
    "id": 1,
    "tipoVeiculo": "CARRO",
    "marca": "Fiat",
    "modelo": "Palio 1.6 mpi 16V 4p",
    "ano": 1997,
    "combustivel": "GASOLINA",
    "preco": "R$ 9.579,00",
    "diaRodizio": "quinta-feira",
    "rodizioAtivo": false
}
~~~
___
### Listando veículos de um usuário
```
GET /api/usuarios/{CPF}/veiculos
```

~~~json
{
    "usuario": {
        "id": 1,
        "nome": "Ayrton Senna",
        "email": "senninha@email.com",
        "cpf": "58306493060",
        "dataNascimento": "1960-03-21"
    },
    "veiculos": [
        {
            "id": 1,
            "tipoVeiculo": "CARRO",
            "marca": "Fiat",
            "modelo": "Palio 1.6 mpi 16V 4p",
            "ano": 1997,
            "combustivel": "GASOLINA",
            "preco": "R$ 9.579,00",
            "diaRodizio": "quinta-feira",
            "rodizioAtivo": false
        },
        {
            "id": 2,
            "tipoVeiculo": "CAMINHAO",
            "marca": "SCANIA",
            "modelo": "G-440 B 8x4 2p (diesel) (E5)",
            "ano": 2016,
            "combustivel": "DIESEL",
            "preco": "R$ 337.899,00",
            "diaRodizio": "quinta-feira",
            "rodizioAtivo": false
        }
    ]
}
~~~