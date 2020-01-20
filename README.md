## 5ª edição Curso de Férias 2020 - Construindo APIs REST com Spring

```

```

* ## Estrutura das aulas

  * **Aula 1**
      * [Slides - aula 1](https://docs.google.com/presentation/d/1FMY-FSPFy8WiVmWvgxOQCdHaggDkFhKKkxYprlBgaBw/edit?usp=sharing)
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
      * [Branch - aula 2]()
  * **Aula 3**
      * JPA
      * Spring Data
      * H2 console
      * Criação da estrutura do pacote **entity** com as entidades do banco de dados
      * Conexão estabelecida com banco de dados
      * Criação da estrutura do pacote **repository**
      * [Branch - aula 3]()
  * **Aula 4**
      * Refatorando entidades com a criação da classe **EntidadeBase**
      * Alterações nos enums **Natureza**, **SituacaoConta** e **TipoLancamento** e seus mapeamentos para não gravar o ordinal dos enums
      * Criação da estrutura do pacote **business**
      * Usando a classe **AppStartupRunner** para alimentar a base de dados do H2 utilizando as classes do pacote **business**
      * [Branch - aula 4]()
  * **Aula 5**
      * Criação da estrutura do pacote **dto** com classes de *Response*
      * Criação da estrutura do pacote **service**
      * Criação da estrutura do pacote **controller** com requisições *GET*
      * Anotações do Jackson para formatação do JSON
      * Requisições via Postman
      * [Branch - aula 5]()
  * **Aula 6**
      * Criação das classes de *Request* no pacote **dto**
      * Criação das requisições *POST*, *PUT* e *DELETE*
      * Criação de requisições *GET* mais complexas
      * [Branch - aula 6]()
  * **Aula 7**
      * Tratamento de códigos de retorno HTTP
      * *Exception handler*
      * Criação de validações na camada **business**
      * Validações nos *requests*
      * [Branch - aula 7]()
  * **Aula 8**
      * Testes unitários da camada **business** com *mock*
      * Testes integrados com banco de dados H2
      * [Branch - aula 8]()
  * **Aula 9**
      * Revisão
        * *Entity*
        * *Repository*
        * *Business*
        * *Service* e *DTOs*
        * *Controller*
        * *Unit tests*
      * [Branch - aula 9]()
  * **Aula 10**
      * Dúvidas
      * [Branch - aula 10]()

* ## Projeto
  * ### Especificações técnicas
    * **Linguagem de programação:** Java - jdk1.8.0_152 ou superior
    * **Gerenciador de dependências:** apache-maven-3.0.4
    * **Spring Boot:** 2.2.0
    * **Banco de dados:** H2 database - http://localhost:8080/h2
    * **Testes unitários:** Mockito + JUnit
    * **Testes de integração:** Rest Assured
    * **Swagger**: [swagger.yaml](etc/swagger.yaml)
    * **Postman**: [Digitalbank.postman_collection.json](etc/Digitalbank.postman_collection.json)

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
           "dataHora": "01/01/2020 15:37:28",
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
              "dataHora": "01/01/2020 15:37:28",
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
      ------ | ------------------------------------------------ | ------------------- | ------ |
      POST   | http://localhost:8080/api/v1/clientes            | *ClienteRequestDTO* | 201 (Created)
      GET    | http://localhost:8080/api/v1/clientes            |                     | 200 (OK) Lista *ClienteResponseDTO*
      GET    | http://localhost:8080/api/v1/clientes/{id}       |                     | 200 (OK) *ClienteResponseDTO*
      PUT    | http://localhost:8080/api/v1/clientes/{id}       | *ClienteRequestDTO* | 204 (No Content)
      DELETE | http://localhost:8080/api/v1/clientes/{id}/conta | *ContaResponseDTO*  | 200 (Ok)

      * **contas**

      Método | URL                                                                               | Entrada                   | Saída
      ------ | --------------------------------------------------------------------------------- | ------------------------- | ------ |
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
      
