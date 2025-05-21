
# 🕹️ Loja de Games - Backend em Spring Boot

<br />
 
<div align="center">
<img src="https://i.imgur.com/w8tTOuT.png" title="source: imgur.com" /> 
</div>
 
<br />
 
<div align="center">
<img src="https://img.shields.io/github/languages/top/rafaelq80/aulas_java_t82?style=flat-square" />
<img src="https://img.shields.io/github/repo-size/rafaelq80/aulas_java_t82?style=flat-square" />
<img src="https://img.shields.io/github/languages/count/rafaelq80/aulas_java_t82?style=flat-square" />
<img src="https://img.shields.io/github/last-commit/rafaelq80/aulas_java_t82?style=flat-square" />
<img src="https://img.shields.io/github/issues/rafaelq80/aulas_java_t82?style=flat-square" />
<img src="https://img.shields.io/github/issues-pr/rafaelq80/aulas_java_t82?style=flat-square" />
<img src="https://img.shields.io/badge/status-construção-yellow" alt="Status: Em Construção">
 
</div>
 
<br />

Claro! Aqui está um modelo de `README.md` para o seu projeto **Loja de Games**, com o mesmo estilo e organização do seu exemplo do Blog Pessoal:

---

````markdown
## 1. Descrição

<br />

O **Loja de Games** é uma aplicação backend desenvolvida em Java com Spring Boot, que permite o gerenciamento de jogos (produtos) classificados por categorias.  
Esse projeto simula uma loja online de games, com foco no aprendizado de construção de APIs RESTful utilizando boas práticas de arquitetura MVC e persistência de dados com JPA.

Entre os principais recursos que a aplicação oferece, destacam-se:

1. Cadastro, edição e remoção de produtos
2. Organização dos produtos por categoria
3. Relacionamento entre categorias e produtos (One-to-Many)
4. Exibição de produtos com preço e imagem
5. Testes com ferramentas como Insomnia

<br />

## 2. Sobre esta API

<br />

A API da Loja de Games segue os princípios REST e foi construída com o framework Spring Boot. Os recursos principais são **Produto** e **Categoria**, cada um com seu CRUD completo.

<br />

### 2.1. Principais funcionalidades da API:

<br />

1. Consulta, criação, edição e exclusão de produtos
2. Cadastro e gerenciamento de categorias
3. Associação de produtos a categorias
4. Exibição de detalhes dos produtos, incluindo preço e imagem
5. Testes e validações realizados via Insomnia

<br />

## 3. Diagrama de Classes

<br />

```mermaid
classDiagram
class Produto {
  - id : Long
  - nome : String
  - descricao : String
  - preco : BigDecimal
  - imagemUrl : String
  - categoria : Categoria
}
class Categoria {
  - id : Long
  - nome : String
  - descricao : String
  - produtos : List<Produto>
}
Categoria "1" --> "0..*" Produto : possui
````

<br />

## 4. Diagrama Entidade-Relacionamento (DER)

<br />

```mermaid
erDiagram
    tb_categorias ||--o{ tb_produtos : possui
    tb_categorias {
        bigint id PK
        varchar(255) nome
        varchar(255) descricao
    }
    tb_produtos {
        bigint id PK
        varchar(255) nome
        text descricao
        decimal preco
        varchar(500) imagem_url
        bigint categoria_id FK
    }
```

<br />

## 5. Tecnologias utilizadas

<br />

| Item                          | Descrição       |
| ----------------------------- | --------------- |
| **Linguagem de programação**  | Java            |
| **Framework**                 | Spring Boot     |
| **ORM**                       | JPA + Hibernate |
| **Banco de dados Relacional** | MySQL           |
| **Documentação**              | SpringDoc       |
| **Testes de API**             | Insomnia        |

<br />

## 6. Requisitos

<br />

* Java JDK 17+
* MySQL Server
* Spring Tool Suite (STS) ou IntelliJ
* Ferramenta de testes como Insomnia ou Postman

<br />

## 7. Como executar o projeto no STS

<br />

### 7.1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/lojagames.git
```

### 7.2. Importar no STS

1. Abra o STS
2. Vá em **File 🡲 Import...**
3. Selecione **Existing Projects into Workspace**
4. Aponte para a pasta onde o repositório foi clonado
5. Finalize a importação e aguarde o carregamento

### 7.3. Configurar o `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/lojagames
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

> 🔁 Altere a porta, se necessário:

```properties
server.port=8082
```

### 7.4. Executar a aplicação

* Vá até o **Boot Dashboard**
* Clique em **Start** para iniciar a aplicação
* Teste os endpoints via Insomnia

<br />

## 8. Testes com Insomnia

<br />

### Criar uma Categoria

**POST** `/categorias`

```json
{
  "nome": "RPG",
  "descricao": "Jogos de interpretação de papéis"
}
```

### Criar um Produto

**POST** `/produtos`

```json
{
  "nome": "Final Fantasy VII Remake",
  "descricao": "Remake do clássico RPG",
  "preco": 299.99,
  "imagemUrl": "https://exemplo.com/imagens/ff7.jpg",
  "categoria": {
    "id": 1
  }
}
```

<br />

## 9. Contato
 
<br />
 
Desenvolvido por [**Luiza**](https://github.com/luizaeg)
Para dúvidas, sugestões ou colaborações, entre em contato via GitHub ou abra uma issue!





