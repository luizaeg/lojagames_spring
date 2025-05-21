
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


Este projeto é um backend de uma loja de games, desenvolvido com **Spring Boot**, utilizando boas práticas de arquitetura com camadas de `model`, `repository` e `controller`.  
Permite o gerenciamento de **produtos (jogos)** e **categorias**, com relacionamento entre eles, e suporte a preços e imagem dos produtos.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL (ou H2)
- Insomnia (para testes de API)
- Lombok (opcional)
- Git & GitHub

---

## 🗃️ Estrutura de Camadas

```

com.seuprojeto.lojagames
├── controller
│   └── ProdutoController.java
│   └── CategoriaController.java
├── model
│   └── Produto.java
│   └── Categoria.java
├── repository
│   └── ProdutoRepository.java
│   └── CategoriaRepository.java
└── application.properties

````

---

## 🛠️ Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/lojagames-backend.git
   cd lojagames-backend
````

2. Configure seu banco de dados MySQL no arquivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/lojagames
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

3. Execute o projeto no Spring Tool Suite (STS), Eclipse ou IntelliJ.

---

## 🔗 Endpoints da API

### 🧩 Categoria

| Método | Rota               | Descrição                 |
| ------ | ------------------ | ------------------------- |
| GET    | `/categorias`      | Lista todas as categorias |
| GET    | `/categorias/{id}` | Busca categoria por ID    |
| POST   | `/categorias`      | Cria nova categoria       |
| PUT    | `/categorias`      | Atualiza categoria        |
| DELETE | `/categorias/{id}` | Deleta categoria por ID   |

### 🕹️ Produto

| Método | Rota             | Descrição               |
| ------ | ---------------- | ----------------------- |
| GET    | `/produtos`      | Lista todos os produtos |
| GET    | `/produtos/{id}` | Busca produto por ID    |
| POST   | `/produtos`      | Cria novo produto       |
| PUT    | `/produtos`      | Atualiza produto        |
| DELETE | `/produtos/{id}` | Deleta produto por ID   |

---

## 🧪 Exemplo de Testes no Insomnia

### ✅ Criar Categoria

**POST** `http://localhost:8082/categorias`

```json
{
  "nome": "Aventura",
  "descricao": "Jogos com exploração e narrativa"
}
```

---

### ✅ Criar Produto com Imagem e Preço

**POST** `http://localhost:8082/produtos`

```json
{
  "nome": "The Legend of Zelda: Breath of the Wild",
  "descricao": "Jogo de mundo aberto com exploração",
  "preco": 249.90,
  "imagemUrl": "https://exemplo.com/imagens/zelda.jpg",
  "categoria": {
    "id": 1
  }
}
```

---

## 📷 Exemplo de Resposta

```json
{
  "id": 1,
  "nome": "The Legend of Zelda: Breath of the Wild",
  "descricao": "Jogo de mundo aberto com exploração",
  "preco": 249.90,
  "imagemUrl": "https://exemplo.com/imagens/zelda.jpg",
  "categoria": {
    "id": 1,
    "nome": "Aventura",
    "descricao": "Jogos com exploração e narrativa"
  }
}
```

---

## 🧠 Boas práticas utilizadas

* Padrão RESTful
* Separação por camadas (MVC)
* Relacionamento OneToMany entre Categoria e Produto
* Documentação e versionamento com Git
* Tipagem correta (BigDecimal para preço, URL como `String` para imagem)

---

## 🗂️ Branches recomendadas

* `feature/crud-produto` – CRUD de Produto com preço e imagem
* `feature/crud-categoria-relacionamento` – CRUD de Categoria e relacionamento com Produto

---

## 👩💻 Autor

Desenvolvido por [**Luiza**](https://github.com/luizaeg) como exercício prático de Spring Boot.
Para dúvidas, sugestões ou colaborações, entre em contato via GitHub ou abra uma issue!




