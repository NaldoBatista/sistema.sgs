## SGS - Sistema de Gerenciamento de Solicitações

Aplicação desenvolvida como solução para o desafio técnico 
proposto para vaga de programador de sistemas de computação.

### Tecnologias Utilizadas
* Backend - SpringBoot
* Frontend - Thymeleaf
* Banco de dados - MySql

### Instruções Para Execução do Projeto
* Ter instalado na máquina Docker 20+ e Docker Compose v2+
* Executar o seguinte comando na raiz do projeto:
    ```
    docker compose up --build
    ```
* O banco de dados será criado e populado automaticamente
* Após a criação e execução dos containers, a aplicação poderá ser acessada 
através da url: <http://localhost:8080/>

### Arquitetura e Soluções

* O projeto foi organizado utilizando a arquitura em camadas MVC (Model- View - Controller)
* A camada de persitência de dados (Repository) foi desenvolvida utlizando o padrão de 
projeto **DAO** (Data Acess Object) e SQL nativo para a ações do CRUD e consultas 
dinâmicas.
* Para implementação da regra de negócio para mudança do status da solicitação,
 foi utlizada uma viriação do padrão de projeto **State**, de modo a permitir a valiçao
 a cada mudança de status.