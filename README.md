# AddressAPI
Para a resolução das questões 01 e 02 foi criado o projeto AddressAPI. Esse projeto foi desenvolvimento em Java versão 8, utilizando:
- Framework Spring MVC versão 4.2.6
- Hibernate versão 5.1.0
- JUnit versão 4.11
- Mockit versão 1.10.19
- Tomcat versão 7.0.30
- Banco de dados Postgres versão 9.4
- Maven versão 4.0

O projeto AddressAPI foi desenvolvido seguindo o padrão MVC que define três camadas de desenvolvimento: a camada de visualização, a camada de lógica de negócios e a camada de acesso a dados. Ele é composto por:

- A classe AddressController recebe as requisições da View para validar e redirecionar para a camada de "negócio" implementada na classe AddressService.
 
- A classe AddressService é responsável por definir as regras de aceite das requisições feitas pela view. Assim como, solicitar funções da camada de persistencia representada pela classe AddressDAO. 

- classe Addres.java onde é mapeado a entidade do banco address através das notações do Hibernate. Além disso, é de acordo com a notação @NotBlank é implementada a validação (Bean Validation) fornecida pelo Hibernate Validator.

- A classe AddressDAO fornece os métodos de acesso ao banco de dados com  a utilização da interface EntityManager do Hibernate;
