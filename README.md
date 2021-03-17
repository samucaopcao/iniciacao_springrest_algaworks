# Sejam bem vindos(as) ao meu repositório : iniciacao_springrest_algaworks


- :mortar_board: Este repositório baseia-se no curso de iniciação ao Spring REST ministrado pelo prof.Alex da AlgaWorks.
- :construction: Foi utilizado para construção as seguintes ferramentas: JDK 11, STS, Postman.
- :memo: Será realizada uma pequena API seguindo o esboço UML abaixo:


![image](https://user-images.githubusercontent.com/59769434/111009831-7148b480-8373-11eb-8d01-d21a544d9ff2.png)

</br>
<h2>Aula 01 - Implementando uma API REST com Spring</h2>

- 1 - Criação da Classe ClienteController (Classe responsável por receber e responder requisição);
- 2 - Criação de Classe Cliente (Classe de dominio , sendo um modelo de cliente);
- 3 - Utilização do Postman: Entendimento de requisições e suas representações, bem como compreensão de cabeçalhos;
- ![image](https://user-images.githubusercontent.com/59769434/111013866-eae69f80-837f-11eb-83e2-bb8e87f51cb7.png)

- 4 - Inclusão das dependências para midia type do tipo xml (Content Negotiation):
 
		<groupId>com.fasterxml.jackson.dataformat</groupId>
		<artifactId>jackson-dataformat-xml</artifactId>
		
<h2>Aula 02 - Persistência, Bean Validation e Exception Handler</h2>

Aula 02 - Introdução

1 - Adição de dependências para utilização de base de dados (clique com o botão direito sobre o projeto > Spring > Add Starts> Digite Spring Data JPA  selecione o combo box e depois MySQL Conection)

2- Configurações dos dados do BD no aprication.properties (pesquisar no Google por Connection URL Syntax do banco que for usar no projeto):<br>
- spring.datasource.url=jdbc:mysql://localhost/osworks?createDatabaseIfNotExist=true&serverTimezone=UTC
- spring.datasource.username=root
- spring.datasource.password=root

3-Adição do FlyWay (clique com o botão direito sobre o projeto > Spring > Add Starts> Digite FlyWay   selecione o combo box para adicioná-lo no pom):

 
![image](https://user-images.githubusercontent.com/59769434/111552299-c6fcd280-8760-11eb-8a8e-5e007f5daf2a.png)
<br><br>
![image](https://user-images.githubusercontent.com/59769434/111552528-4be7ec00-8761-11eb-9ad3-4e74accaa9ec.png)



 

Após inserção do FlyWay devemos criar em src/main/resources a pasta db e dentro desta a pasta migration (nela são salvas nossos scripts para criação do nosso banco e alterações)<br> 

De stop na aplicação para criarmos o nosso primeiro arquivo atentando-se para a convenção onde o nome do arquivo começa com V de versão seguindo do numero da versão seguido de dois underline e uma descrição EX.: V001__cria-tabela-cliente.sql
 
 
![image](https://user-images.githubusercontent.com/59769434/111552628-80f43e80-8761-11eb-97ae-0f45654f3c93.png)

 

<br>
Editando esse arquivo abrindo como arquivo de texto (clique com o botão direito > open with) colocaremos a query que criará o banco de dados caso ele não exista:
CREATE TABLE cliente
(
id BIGINT NOT NULL AUTO_INCREMENT,
nome VARCHAR(60) NOT NULL,
email VARCHAR(255) NOT NULL, 
telefone VARCHAR(20) NOT NULL,

PRIMARY KEY (id)
);

Obs.: Rode o projeto para testar somente após colocar tudo o que deseja dentro do script caso contrário o Java retornará um erro dizendo que o script foi editado. Assim para corrigi-lo deveríamos ir ao banco e excluir a linha do schema flyway. Ou podemos criar a V002 do script.
Criamos um script V002 para alterar o nome da coluna telefone para fone.
Após o término nosso banco ficará assim:

![image](https://user-images.githubusercontent.com/59769434/111552609-746fe600-8761-11eb-8ef8-9321a109e32e.png)

 



<h2>Aula 03 - Técnicas e Boas Práticas</h2>
- :construction: Em construção...

<h2>Aula 04 - Alcançando o próximo nível</h2>
- :construction: Em construção...

</br></br>
- 🚶🚶🚶 ...Estamos caminhando.
