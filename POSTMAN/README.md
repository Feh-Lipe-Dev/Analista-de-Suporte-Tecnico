# Plano e Checklist de Testes de API — JSONPlaceholder

Este documento consiste na documentação oficial e no checklist de execução de testes das requisições HTTP realizadas na API pública **JSONPlaceholder** [(https://jsonplaceholder.typicode.com/)](https://jsonplaceholder.typicode.com/).  
O objetivo é validar a conformidade dos métodos HTTP, as estruturas de dados retornadas e o comportamento esperado dos endpoints de posts.

---

## 1. Informações Gerais do Projeto

* **Ambiente de Teste:** Mock API (JSONPlaceholder)
* **Ferramenta Utilizada:** Postman
* **Base URL:** `https://jsonplaceholder.typicode.com`
* **Formato de Dados:** `application/json`
* **Autor/Analista:** Felipe Gonçalves

---

## 2. Matriz de Checklist de Testes

| ID do Caso | Método | Endpoint | Objetivo do Teste | Status Esperado | Status Obtido | Resultado |
| :--- | :---: | :--- | :--- | :---: | :---: | :---: |
| **CT-01** | `GET` | `/posts` | Buscar todas as postagens do banco de dados. | `200 OK` | `200 OK` | **Aprovado** |
| **CT-02** | `GET` | `/posts/1` | Buscar uma postagem específica através do ID `1`. | `200 OK` | `200 OK` | **Aprovado** |
| **CT-03** | `POST` | `/posts` | Criar uma nova postagem enviando dados válidos. | `201 Created` | `201 Created` | **Aprovado** |
| **CT-04** | `PUT` | `/posts/1` | Alterar por completo os dados da postagem com ID `1`. | `200 OK` | `200 OK` | **Aprovado** |
| **CT-05** | `DELETE`| `/posts/1` | Excluir logicamente/fisicamente a postagem com ID `1`. | `200 OK` | `200 OK` | **Aprovado** |
| **CT-06** | `GET` | `/posts/1` | Tentar buscar a postagem com ID `1` após sua exclusão. | `404 Not Found` | `200 OK` | **Falha de Mock*** |

> *\*Nota sobre o CT-06:* Como o JSONPlaceholder é uma API pública e estática para testes rápidos, as operações de escrita e exclusão (`POST`, `PUT`, `DELETE`) simulam o sucesso mas não alteram o estado persistido no servidor real. Portanto, a busca pelo ID excluído ainda retorna o dado original. Em um ambiente produtivo real, este caso deveria retornar `404 Not Found`.

---

## 3. Detalhamento e Evidências dos Casos de Teste

### CT-01: Buscar Todas as Postagens (`GET /posts`)

* **Descrição:** Valida a listagem completa de posts da plataforma.
* **Requisição:**

    ```http
    GET /posts HTTP/1.1
    Host: jsonplaceholder.typicode.com
    ```

* **Critérios de Aceite:**

* Código de Status: `200 OK`
* Payload: Array contendo exatamente 100 objetos.
* **Evidência de Resposta (`buscarTodos.json`):**

    ```json
    [
      {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
      },
      {
        "userId": 1,
        "id": 2,
        "title": "qui est esse",
        "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
      }
      // ... truncado para fins de legibilidade (Total de 100 registros)
    ]
    ```

### CT-02: Buscar Postagem por ID (`GET /posts/1`)

* **Descrição:** Valida a recuperação de um único registro ativo utilizando um parâmetro de rota.
* **Requisição:**

    ```http
    GET /posts/1 HTTP/1.1
    Host: jsonplaceholder.typicode.com
    ```

* **Critérios de Aceite:**
* Código de Status: `200 OK`
* Payload: Objeto isolado contendo as chaves `userId`, `id`, `title` e `body`.
* **Evidência de Resposta (`buscarID.json`):**

    ```json
    {
      "userId": 1,
      "id": 1,
      "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
      "body": "quia et suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"
    }
    ```

### CT-03: Criar Nova Postagem (`POST /posts`)

* **Descrição:** Garante que a API aceita a inserção de novos recursos na coleção de posts.
* **Requisição:**

    ```http
    POST /posts HTTP/1.1
    Host: jsonplaceholder.typicode.com
    Content-Type: application/json

    {
      "title": "teste verbo POST",
      "body": "teste verbo POST",
      "userId": 1
    }
    ```

* **Critérios de Aceite:**
* Código de Status: `201 Created`
* Payload: Retorno do ID autoincrementado gerado pela API (ID `101`).
* **Evidência de Resposta (`criarPost.json`):**

    ```json
    {
      "id": 101,
      "title": "teste verbo POST",
      "body": "teste verbo POST"
    }
    ```

### CT-04: Alterar/Atualizar Postagem (`PUT /posts/1`)

* **Descrição:** Valida a substituição/atualização integral dos dados do post de ID `1`.
* **Requisição:**

    ```http
    PUT /posts/1 HTTP/1.1
    Host: jsonplaceholder.typicode.com
    Content-Type: application/json

    {
      "id": 1,
      "title": "Título Atualizado",
      "body": "Corpo da mensagem atualizado.",
      "userId": 1
    }
    ```

* **Critérios de Aceite:**
* Código de Status: `200 OK`
* Payload: Retorno confirmando as alterações efetuadas ou o ID afetado.
* **Evidência de Resposta (`alterarPost.json`):**

    ```json
    {
      "id": 1
    }
    ```

### CT-05: Excluir Postagem (`DELETE /posts/1`)

* **Descrição:** Valida o envio de requisições de remoção para o endpoint específico do post.
* **Requisição:**

    ```http
    DELETE /posts/1 HTTP/1.1
    Host: jsonplaceholder.typicode.com
    ```

* **Critérios de Aceite:**
* Código de Status: `200 OK` ou `204 No Content`
* Payload: Corpo vazio ou objeto vazio confirmando a exclusão.
* **Evidência de Resposta (`excluirPost-1.json`):**

    ```json
    {}
    ```

### CT-06: Buscar Postagem Excluída (Validação Pós-Exclusão)

* **Descrição:** Cenário negativo para verificar a persistência e indisponibilidade do recurso após remoção.
* **Requisição:**

    ```http
    GET /posts/1 HTTP/1.1
    Host: jsonplaceholder.typicode.com
    ```

* **Comportamento da API Simulada:** O recurso continua sendo retornado devido às limitações do Mock público do JSONPlaceholder.
* **Evidência de Resposta (`buscaPost-1-excluido.json`):**

    ```json
    {
      "userId": 1,
      "id": 1,
      "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
      "body": "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"
    }
    ```

---

## 4. Conclusão e Padrões de Aceitação

A suíte de testes cobriu de forma bem-sucedida as principais operações de CRUD utilizando as convenções RESTful da arquitetura HTTP.

1. **Padrões Cumpridos:** Todos os verbos HTTP retornaram códigos na faixa de sucesso esperada para mocks (`2xx`).

2. **Ajustes Futuros recomendados:** Em um ambiente de produção real integrado a um banco de dados persistente, sugere-se a automação utilizando scripts em JavaScript dentro do próprio Postman (aba *Tests*) para validação de Schema JSON e testes de regressão automatizados.
