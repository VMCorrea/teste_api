
# API Teste

Este projeto é um estudo de programação Back-end Java com a utilização de Spring Boot.

Usando um servidor e um banco de dados embutidos, o programa consiste em uma API REST que simula um simples sistema de cadastro de usuários. Executa todas as operações CRUD para objetos do tipo usuário, utilizando os principais métodos HTTP (GET, POST, PUT, DELETE).

# Documentação

Segue neste documento README.md, o manual de requisições para utilizar esta API.

Para a documentação do código, foi utilizado a funcionalidade do javadoc. Os arquivos referentes a documentação do javadoc se encontram na pasta /doc do projeto.

# Instalação
O projeto não requer nenhuma instalação complexa, basta ter o Java instalado na máquina.

# Uso
## 1. Iniciar
Para iniciar a aplicação, basta executar o jar através de linha de comando:
					    
	java -jar path/to/fila/teste_api-X.X.X.jar

Assim que a o Spring Boot terminar de executar, já é possível fazer requisições e acessar o banco de dados.
A aplicação irá utilizar a porta 8080. Para acessar o banco de dados basta abrir o navegador e ir até [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/) e logar trocando apenas o campo 'JDBC URL' para 'jdbc:h2:mem:db'.

Para obter o arquivo jar é possível compilar o projeto através do Maven, ou então encontrar [aqui](https://github.com/VMCorrea/teste_api/releases).
## 2. JSON
A API consome e produz arquivos do tipo JSON. Dentro da pasta /target/json-examples contém arquivos json com os formatos necessários para a API funcionar.
## 3. Usuario
Classe que guarda os dados do usuário. Contém os seguintes atributos:
* ID ( Gerado pelo banco de dados )
* Nome
* CPF
* Data de Lançamento
* Sexo
* Cargo
* Perfil
* Status

#### 3.1 GET Request (Único)

Requisição do tipo GET, que busca apenas um usuário no banco de dados.
A busca deve ser feita utilizando o id do usuário.
    
    curl --request GET --url http://localhost:8080/artigos/{id}

#### 3.2 GET Request (Listagem)

Requisição do tipo GET, que lista os usuários.
É possível usar como filtros opcionais os atributos nome, cpf, cargo, perfil e status via parâmetros de URL.

    curl --request GET --url http://localhost:8080/usuarios?nome=Joao&cargo=GERENTE

#### 3.3 POST Request
Requisição do tipo POST, para inserção de um novo usuário no banco de dados.

    curl --request POST --url http://localhost:8080/usuarios

Junto da requisição, é necessário enviar um arquivo do tipo JSON.
A inserção deve seguir as seguintes regras para funcionar:
* O ID não deve ser enviado.
* Todos os campos devem ser preenchidos.
* CPF precisa ser válido

#### 3.4 PUT Request
Requisição do tipo PUT, para atualizar um usuário no banco de dados.

    curl --request PUT --url http://localhost:8080/usuario/{id}

A requisição deve enviar um arquivo JSON com os dados do usuário que serão atualizados.

#### 3.5 DELETE Request
Requisição do tipo DELETE, para remover um usuário do banco de dados.

    curl --request DELETE --url 'http://localhost:8080/usuarios/{id}'
   
#### 3.6 GET Request (Listagem Customizada)

Requisição do tipo GET, que lista os usuários femininos com mais de 18 anos.

    curl --request GET --url http://localhost:8080/usuarios/mulheres-adultas
  
#### 3.7 GET Request (Listagem Customizada)

Requisição do tipo GET, que lista os usuários que o cpf inicia com o digito 0.

    curl --request GET --url http://localhost:8080/usuarios/cpf-inicio-zero

## 4. Cargos
Classe que representa um cargo. Atualmente contém apenas o atributo 'titulo', que serve como identificador único.

#### 4.1 GET Request (Listagem)

Requisição do tipo GET, que lista todos os cargos.

    curl --request GET --url http://localhost:8080/cargos

#### 4.2 POST Request
Requisição do tipo POST, que insere um cargo no banco de dados.

    curl --request POST --url http://localhost:8080/cargos

Junto da requisição, é necessário enviar um arquivo do tipo JSON.
A inserção deve seguir as seguintes regras para funcionar:
* O Título não pode ser nulo.

## 5. Perfil

Classe que representa um perfil. Atualmente contém apenas o atributo 'titulo', que serve como identificador único.


#### 5.1 GET Request (Listagem)

Requisição do tipo GET, que lista todos os perfis.

    curl --request GET --url http://localhost:8080/perfis

#### 5.2 POST Request
Requisição do tipo POST, que insere um perfil no banco de dados.

    curl --request POST --url http://localhost:8080/perfis

Junto da requisição, é necessário enviar um arquivo do tipo JSON.
A inserção deve seguir as seguintes regras para funcionar:
* O Título não pode ser nulo.
