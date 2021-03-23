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

De stop na aplicação para criarmos o nosso primeiro arquivo atentando-se para a convenção onde o nome do arquivo começa com V de versão seguindo do número da versão seguido de dois underline e uma descrição EX.: V001__cria-tabela-cliente.sql
 
 
![image](https://user-images.githubusercontent.com/59769434/111552628-80f43e80-8761-11eb-97ae-0f45654f3c93.png)

 

<br>
Editando esse arquivo abrindo-o como arquivo de texto (clique com o botão direito > open with > Text Editor) colocaremos a query que criará o banco de dados caso ele não exista:
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

O JAKARTA PERSISTENCE (antigamente chamado de Jakarta Persistence API = JPA) é uma API para Mapeamento de Objeto Relacional (ORM) 
Hibernate é uma implementação do JPA.
Spring Data JPA não é uma implementação do JPA é apenas uma biblioteca para criar Repositories
Realizaremos agora o mapeamento da classe cliente (ligaremos ela ao banco de dados com as anotações)

Para debugar podemos colocar no aplication.properties o seguinte código spring.jpa.show-sql=true o qual mostrará no log o código SQL.




<h2>Aula 03 - Técnicas e Boas Práticas</h2>
Criaremos as classes OrdemServico e o Enum StatusOrdemServico. Após esse passo usaremos as anotações necessárias e utilizaremos o script abaixo para a criação da tabela no banco de dados:
<br><br>

CREATE TABLE ordem_servico
(
id BIGINT NOT NULL AUTO_INCREMENT,
cliente_id BIGINT NOT NULL,
descricao TEXT NOT NULL,
preco DECIMAL (10,2) NOT NULL,
status VARCHAR(20) NOT NULL,
data_abertura DATETIME NOT NULL,
data_finalizacao DATETIME ,

PRIMARY KEY (id)

);

ALTER TABLE ordem_servico ADD CONSTRAINT  fk_ordem_sevico_cliente
FOREIGN KEY (cliente_id) REFERENCES cliente (id);
<br><br>
Assim criaremos um arquivo no diretório db/migration , para que o Script não seja executado criaremos com um nome fora do padrão (sem iniciar com V ...), após inserir a querie acima citada, podemos renomeá-lo corretamente.(V003__cria-tabela-ordem-servico.sql)
<br><br>

<h3> RESUMINDO:</h3>
<br><br>
1 – Criar classe model OrdemServico com atributos e anotações (
@id, @GeneratedValue(strategy = GenerationType.IDENTITY), @ManyToOne, @Enumerated(EnumType.STRING);
<br><br>
2 – Criar interface repository OrdemServicoRepository (posteriormente acrescentar métodos de busca);
<br><br>
3 – Criar um arquivo no diretório db/migration conforme descrito acima;
<br><br>
4 – Criar a Classe de serviço GestaoOrdemService criando os serviços de criação de uma ordem de serviço, porém para isso devemos injetar a dependência (@Autowired) criando uma instancia de ordemServicoRepository e uma de ordemServiço;
<br><br>
5 – Criar a Classe controladora  OrdemServicoController colocando as anotações :
<br><br>
@RequestController (Para marcar a classe como controladora);<br>
@RequestMapping(“/ordens-servico”) – Para determinarmos o caminho padrão do nosso EndPoint;<br>
@AutoWired ao criar a injeção de dependência ao criar o private GestaoOrdemServicoService gestaoOrdemServicoService;<br>
@PostMapping – Para adicionar ou incluir alguma coisa<br>
@ResponseStatus(HttpStatus.CREATED) informa o status de criação após a anotação acima<br>
<br><br>
Criar uma nova pasta para requisições no Postman, sem esquecer de alterar o endereço do EndPoint.
<br><br>

![image](https://user-images.githubusercontent.com/59769434/112075254-e9bf2a80-8b56-11eb-9956-f6ea2822a54d.png)


<h2>Aula 04 - Alcançando o próximo nível</h2>
- :construction: Em construção...

</br></br>
- 🚶🚶🚶 ...Estamos caminhando.
