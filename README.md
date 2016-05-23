# AddressAPI
Para a resolução das questões 01 e 02 foi criado o projeto AddressAPI. Esse projeto foi desenvolvimento em Java versão 8, utilizando:
- Framework Spring MVC versão 4.2.6
- Hibernate versão 5.1.0
- JUnit versão 4.11
- Mockito versão 1.10.19
- Tomcat versão 7.0.30
- Banco de dados Postgres versão 9.4
- Maven versão 4.0

O projeto AddressAPI foi desenvolvido seguindo o padrão MVC que define três camadas de desenvolvimento: a camada de visualização, a camada de lógica de negócios e a camada de acesso a dados. Ele é composto por:

- A classe AddressController recebe as requisições da View para validar e redirecionar para a camada de "negócio" implementada na classe AddressService.
 
- A classe AddressService é responsável por definir as regras de aceite das requisições feitas pela view. Assim como, solicitar funções da camada de persistencia representada pela classe AddressDAO. 

- classe Addres.java onde é mapeado a entidade do banco address através das notações do Hibernate. Além disso, é de acordo com a notação @NotBlank é implementada a validação (Bean Validation) fornecida pelo Hibernate Validator.

- A classe AddressDAO fornece os métodos de acesso ao banco de dados com  a utilização da interface EntityManager do Hibernate;

Resolução da questão 01:
 - A funcionalidade de receber e responder requisições JSON foi implementada pelo método getAddressInJSON(String cep) que recebe uma string referente ao cep que deve ser validado e consultado. Esse método da classe AddressController recebe o cep e o envia para o método fidByCep(String cep) da classe AddressService. 
 - Na classe AddressService é verificado se o cep é válido com o método clearCep(String cep) que retira todos os caracteres inválidos e/ou letras da string recebida. Em seguida verifica-se se a string possui 8 digitos, caso possua, o cep é considerado válido.
 - Caso o cep seja válido, ele é enviado como parâmetro de busca do método findAddress que por sua vez o envia como paramêtro para consulta no banco através do método findByCep da classe AddressDAO.
 - Se não existir endereço cadastrado para o cep enviado, o último caracter é substituido por zero de maneira recursiva até que um endereço seja encontrado ou todos os caracteres sejam zero.
 - O resultado dessa requisição é incluído na variável address da classe JSON Response, assim como uma mensagem indicando se o endereço é inválido, ou se já existe no banco de dados.
 - O retorno do JSON é exibido no corpo da página. 
 
Resolução da questão 02:
 - O usuário pode consultar, atualizar ou cadastrar o endereço através da página JSP AddressForm. 
 - O primeiro campo a ser preenchido é o campo "CEP", e após o preenchimento é disparado o evento Ajax onBlur que invoca o método getAddressInJSON(String cep) e retorna um alerta para a tela informando a situação do cep enviado(inválido, cadastrado ou não cadastrado)
 - Ao clicar em enviar é chamado o método save(@Valid Address address, BindingResult result, RedirectAttributes redirect) que recebe como parâmetro o objeto Address preenchido pelo usuário. A notação @Valid indica que esse objeto é validado pelo método validate() da classe AddressValidator que implementa a interface Validator do Spring.
 - Em caso de erro, indicado pelo parâmetro result, retorna-se (usando o parametro redirect) para a página AddressForm.jsp com a mensagem de erro. Caso contrário, verifica-se se o cep é válido utilizando a função findByCep(String cep). 
 - Caso o cep seja inválido retorna-se (usando o parametro redirect) para a página AddressForm.jsp com a mensagem de "CEP inválido"
 - Se o cep for válido, o mesmo é eviado como pârametro para ser incluido ou atualizado no banco de dados. 
 - Em seguida, o método list(Response response) é invocado para atualizar a lista com todos os endereços cadastrados, adicionar uma mensagem referente a inclusão ou atualização do endereço e redirecionar o usuário para a página AddressConsult.jsp.
 - Na tela de visualização de endereço é possível deletar um registro. Caso o usuário clique no botão "Deletar" o evento onClick do Ajax é disparado para invocar o método delete(Response response) do AddressController enviando o id do endereço selecionado na tabela de endereços.
 - O Id é utilizado como parâmetro para o método findById que retorna o objeto Address que deve ser deletado do banco pelo método delete(Address address) da classe AddressDAO.
 - Após deletar o registro uma mensagem é enviada, via classe JSON Response, para a página AddressConsult.jsp.
  
 
