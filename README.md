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
      * Finalizando criação das regras de negócio nas classes do pacote **service**
      * [Branch - aula 5](https://github.com/materasystems/curso-de-ferias-2020-spring/tree/aula5)

* ### Modelagem
    ![modelagem](etc/digitalbank-der.png)