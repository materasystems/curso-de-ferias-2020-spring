## 5ª edição Curso de Férias 2020 - Construindo APIs REST com Spring

```

```

* ## Estrutura das aulas

  * **Aula 1**
      * [Slides - aula 1](https://docs.google.com/presentation/d/1FMY-FSPFy8WiVmWvgxOQCdHaggDkFhKKkxYprlBgaBw/edit?usp=sharing)
      * [Branch - aula 1](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula1)
  * **Aula 2**
      * [Slides - aula 2](https://docs.google.com/presentation/d/1kJJVGopZkU5yBdLXxFIguXVzMekdkkUaSXEHMdcmQ_U/edit?usp=sharing)
      * Criação do projeto inicial com [Spring Initializr](https://start.spring.io/)
      * Entendendo o contexto do Spring
        * Inversão de controle
        * Injeção de dependências
      * Criação de beans no contexto do Spring e possíveis problemas
        * Uso da interface **ApplicationRunner**
        * Uso de *annotations* **@Component**, **@Autowired**, **@Primary** e **@Qualifier**
      * Uso de Spring Profiles
      * [Branch - aula 2](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula2)
  * **Aula 3**
      * JPA
      * Spring Data
      * H2 console
      * Criação da estrutura do pacote **entity** com as entidades do banco de dados
      * Conexão estabelecida com banco de dados
      * Criação da estrutura do pacote **repository**
      * [Branch - aula 3](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula3)
  * **Aula 4**
      * Refatorando entidades com a criação da classe **EntidadeBase**
      * Criação da estrutura do pacote **dto** com classes de *Request* e *Response*
      * Refatorando entidades e DTOs com o uso de Lombok
      * Alterações nos enums **Natureza**, **SituacaoConta** e **TipoLancamento** e seus mapeamentos para não gravar o ordinal ou a string dos enums
      * Criação da estrutura do pacote **service**
      * [Branch - aula 4](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula4)
  * **Aula 5**
      * Criando consultas necessárias nas classes *Repository* para as validações feitas nas classes *Service*
      * Finalizando criação das classes de *Request* e *Response* no pacote **dto**
      * Finalizando criação das regras de negócio nas classes do pacote **service**
      * [Branch - aula 5](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula5)
  * **Aula 6**
      * Usando a classe **AppStartupRunner** para alimentar a base de dados do H2 utilizando as classes do pacote **service**
      * Criação da estrutura do pacote **controller** com requisições *GET*, *POST* e *PUT* para a entidade de Cliente
      * Tratamento de códigos de retorno HTTP
      * Requisições via Postman
      * Anotações do Jackson para formatação do JSON
      * [Branch - aula 6](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula6)
  * **Aula 7**
      * Validações nos *requests* usando anotações
      * *Exception handler* para tratamento de exceções
      * Criação de requisições *POST* para a entidade de Conta
      * [Branch - aula 7](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula7)
  * **Aula 8**
      * Finalizando requisições *POST*, *GET* e *DELETE* para a entidade de Conta
      * Adicionando Swagger
      * Refatorando validações de negócio e *Exception handler* para centralizar as mensagens de erro no arquivo *messages.properties*
      * Aplicando i18n utilizando o arquivo *messages_en.properties*
      * [Branch - aula 8](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula8)
  * **Aula 9**
      * Tratando exceções não esperadas com HTTP status 500 no *Exception handler*
      * Adicionando logs com Logback
      * Testes unitários com JUnit 5 e Mockito
      * [Branch - aula 9](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula9)
  * **Aula 10**
      * Finalizando cenários de testes unitários com JUnit 5 e Mockito
      * Testes de integração com JUnit 5, Rest Assured e Hamcrest
      * Criando profile específico no Maven para testes de integração
      * [Branch - aula 10](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula10)

* ## Projeto
  * ### Especificações técnicas
    * **Linguagem de programação:** Java - JDK 8 ou superior
    * **Gerenciador de dependências:** Maven 3 ou superior
    * **Spring Boot:** 2.2.4
    * **Banco de dados:** H2 database - http://localhost:8080/digitalbank/h2-console
    * **Testes unitários:** JUnit 5 + Mockito
    * **Testes de integração:** JUnit 5 + Rest Assured + Hamcrest
    * **Swagger**: [swagger.yaml](etc/swagger.yaml)
    * **Postman**: [Digitalbank.postman_collection.json](etc/Digitalbank.postman_collection.json)

  * ### Modelagem
      ![modelagem](etc/digitalbank-der.png)

  * ### Representações

      Os modelos de entrada e saída são representados no formato JSON

      *ClienteRequestDTO*
      ```json
      {
        "nome": "Pedro",
        "cpf": "74739910004",
        "telefone": 987665214,
        "rendaMensal": 10000.0,
        "logradouro": "Av. São Paulo",
        "numero": 120,
        "complemento": "Casa",
        "bairro": "Centro",
        "cidade": "Maringá",
        "estado": "PR",
        "cep": "85006854"
      }
      ```

      *ClienteResponseDTO*
      ```json
      {
         "dados": {
            "id": 1,
            "nome": "Pedro",
            "cpf": "74739910004",
            "telefone": 987665214,
            "rendaMensal": 10000.0,
            "logradouro": "Av. São Paulo",
            "numero": 120,
            "complemento": "Casa",
            "bairro": "Centro",
            "cidade": "Maringá",
            "estado": "PR",
            "cep": "85006854"
         }
      }
      ```

      *ContaResponseDTO*
      ```json
      {
         "dados": {
           "idCliente": 1,
           "idConta": 1,
           "numeroAgencia": 1,
           "numeroConta": 987665214,
           "situacao": "A",
           "saldo": 0
         }
      }
      ```
      
      *LancamentoRequestDTO*
      ```json
      {
        "valor": 100.0,
        "descricao": "Lançamento"
      }
      ```

      *TransferenciaRequestDTO*
      ```json
      {
        "numeroAgencia": 1,
        "numeroConta": 995410233,
        "valor": 50.0,
        "descricao": "Transferência"
      }
      ```

      *ComprovanteResponseDTO*
      ```json
      {
         "dados": {
           "idLancamento": 1,
           "codigoAutenticacao": "e2758c09-3539-4af9-b14b-66f561208b53",
           "dataHora": "31-12-2020 15:37:28",
           "valor": 50.0,
           "natureza": "D",
           "tipoLancamento": "T",
           "numeroAgencia": 1,
           "numeroConta": 995410233,
           "descricao": "Transferência"
         }
      }
      ```

      *ExtratoResponseDTO*
      ```json
      {
        "dados": {
          "conta": {
            "idCliente": 1,
            "idConta": 1,
            "numeroAgencia": 1,
            "numeroConta": 987665214,
            "situacao": "A",
            "saldo": 50.0
          },
          "lancamentos": [
            {
              "idLancamento": 1,
              "codigoAutenticacao": "e2758c09-3539-4af9-b14b-66f561208b53",
              "dataHora": "31-12-2020 15:37:28",
              "valor": 50.0,
              "natureza": "D",
              "tipoLancamento": "T",
              "numeroAgencia": 1,
              "numeroConta": 995410233,
              "descricao": "Transferência"
            }
          ]
        }
      }
      ```

  * ### Requisições

      * **clientes**

      Método | URL                                              | Entrada             | Saída
      ------ | ------------------------------------------------ | ------------------- | ------
      POST   | http://localhost:8080/api/v1/clientes            | *ClienteRequestDTO* | 201 (Created)
      GET    | http://localhost:8080/api/v1/clientes            |                     | 200 (OK) Lista *ClienteResponseDTO*
      GET    | http://localhost:8080/api/v1/clientes/{id}       |                     | 200 (OK) *ClienteResponseDTO*
      PUT    | http://localhost:8080/api/v1/clientes/{id}       | *ClienteRequestDTO* | 204 (No Content)
      DELETE | http://localhost:8080/api/v1/clientes/{id}/conta | *ContaResponseDTO*  | 200 (Ok)

      * **contas**

      Método | URL                                                                               | Entrada                   | Saída
      ------ | --------------------------------------------------------------------------------- | ------------------------- | ------
      GET    | http://localhost:8080/api/v1/contas                                               |                           | 200 (OK) Lista *ContaResponseDTO*
      POST   | http://localhost:8080/api/v1/contas/{id}/bloquear                                 |                           | 204 (No Content)
      POST   | http://localhost:8080/api/v1/contas/{id}/desbloquear                              |                           | 204 (No Content)
      POST   | http://localhost:8080/api/v1/contas/{id}/depositar                                | *LancamentoRequestDTO*    | 200 (Ok) *ComprovanteResponseDTO*
      POST   | http://localhost:8080/api/v1/contas/{id}/sacar                                    | *LancamentoRequestDTO*    | 200 (Ok) *ComprovanteResponseDTO*
      POST   | http://localhost:8080/api/v1/contas/{id}/pagar                                    | *LancamentoRequestDTO*    | 200 (Ok) *ComprovanteResponseDTO*
      POST   | http://localhost:8080/api/v1/contas/{id}/transferir                               | *TransferenciaRequestDTO* | 200 (Ok) *ComprovanteResponseDTO*
      GET    | http://localhost:8080/api/v1/contas/{idConta}/lancamentos                         |                           | 200 (Ok) Lista *ComprovanteResponseDTO*
      GET    | http://localhost:8080/api/v1/contas/{idConta}/lancamentos/{idLancamento}          |                           | 200 (Ok) *ComprovanteResponseDTO*
      DELETE | http://localhost:8080/api/v1/contas/{idConta}/lancamentos/{idLancamento}          |                           | 204 (No Content)
      POST   | http://localhost:8080/api/v1/contas/{idConta}/lancamentos/{idLancamento}/estornar |                           | 200 (Ok) *ComprovanteResponseDTO*
