# ClimaAPI

API REST em Spring Boot que consulta a previsão do tempo de uma cidade utilizando a [WeatherAPI](https://www.weatherapi.com/).

## Tecnologias

- Java 25
- Spring Boot 4.1.1 (Spring Web MVC)
- Maven

## Estrutura do projeto

```
src/main/java/com/example/ClimaAPI
├── controller
│   └── Controller.java      # Endpoint REST
├── service
│   └── Service.java         # Regra de negócio e chamada à WeatherAPI
└── ClimaApiApplication.java # Classe principal (main)
```

## Pré-requisitos

- JDK 25
- Maven (ou usar o wrapper `mvnw` incluído no projeto)
- Uma chave de API gratuita da [WeatherAPI](https://www.weatherapi.com/)

## Como executar

1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
   cd ClimaAPI/ClimaAPI
   ```

2. Configure sua chave da WeatherAPI em `src/main/java/com/example/ClimaAPI/service/Service.java` (campos `token` e `apiUrl`).

3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

4. A aplicação sobe por padrão em `http://localhost:8080`.

## Endpoint

### Consultar previsão do tempo

```
GET /clima/{cidade}
```

**Parâmetro:**
- `cidade` — nome da cidade a ser consultada.

**Exemplo:**
```
GET http://localhost:8080/clima/Sao Paulo
```

**Resposta:** retorna o JSON bruto retornado pela WeatherAPI com os dados meteorológicos da cidade informada, em português (`lang=pt`).

Em caso de falha na chamada à WeatherAPI, o endpoint retorna uma mensagem de erro com o código de status e o corpo da resposta da API externa.

## Testes

Para rodar os testes automatizados:

```bash
./mvnw test
```
