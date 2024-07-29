
<h1 align="center">
  Maestria campeões do LOL
</h1>

## Sobre
Este projeto foi desenvolvido com o objetivo de estudar e aprimorar o consumo de APIs externas, utilizando a API da Riot Games. Ao longo deste projeto, foram solidificados conhecimentos sobre APIs, além de conversão e leitura de dados em JSON.

Observação: O JSON fornecido pela Riot Games pode não estar atualizado, o que pode resultar na aparição de campeões mais novos como null.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [ApiRiot Games](https://developer.riotgames.com/apis)

## Práticas adotadas

- API REST
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/last-match-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com):

- Consultar a maestria
```

$ http GET :8080/champions?name=pedra&tag=team&quant=2

name =  Nome de usuario da Riot Games

tag = Tag da sua conta Riot Games

quant = Quantidade de campeões que mostrará

```

[
  [
    {
        "nameChampion": "Annie",
        "championId": 1,
        "championPoints": "124325",
        "championLevel": "13"
    },
    {
        "nameChampion": "Draven",
        "championId": 119,
        "championPoints": "43231",
        "championLevel": "7"
    },
]

```


## Detalhes do Projeto

- **GroupId**: com.marcos
- **ArtifactId**: last-match
- **Versão**: 0.0.1-SNAPSHOT

## Requisitos

- Java JDK 21 ou superior
- Maven 3.3.0 ou superior
