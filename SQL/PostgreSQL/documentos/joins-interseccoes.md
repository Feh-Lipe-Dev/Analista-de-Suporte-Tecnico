# JOIN

## Por que precisamos?

JOIN combina linhas de duas ou mais tabelas com base em uma condição de relacionamento (geralmente FK → PK). Sem JOINs, precisaríamos de queries separadas e juntar os dados na aplicação — o que seria lento e frágil.

## Tipo de JOIN

| Tipo/sintaxe | Descrição |
|--------------|-----------| 
| `INNER JOIN` | Retorna apenas as linhas que possuem correspondência em ambas as tabelas |
| `LEFT JOIN` | Retorna todas as linhas da tabela da esquerda e, se não houver correspondência, preenche com NULL |
| `RIGHT JOIN` |Retorna todas as linhas da tabela da direita e, se não houver correspondência, preenche com NULL |
| `FULL JOIN` | Retorna todas as linhas de ambas as tabelas, preenchendo com NULL onde não há correspondência |
| `CROSS JOIN` |Realiza o produto cartesiano (todas as combinações possíveis entre linhas das duas tabelas) |

---

## Exemplos Práticos

### 1. INNER JOIN: Clientes que realizaram pedidos

Este comando retorna apenas os clientes que possuem registros na tabela `tb_pedido`. Clientes sem pedidos não aparecerão na lista.

```sql
SELECT c.nome, p.id AS numero_pedido
FROM tb_clientes c
INNER JOIN tb_pedido p ON c.id = p.fk_cliente
ORDER BY c.nome;
```

### 2. LEFT JOIN: Listando todos os clientes e seus pedidos

Diferente do `INNER JOIN`, aqui queremos ver **todos** os clientes. Se um cliente não comprou nada, o campo do pedido virá como `NULL`.

```sql
SELECT c.nome, p.id AS numero_pedido
FROM tb_clientes c
LEFT JOIN tb_pedido p ON c.id = p.fk_cliente;
```

📍Nota: Este padrão é excelente para encontrar clientes inativos (aqueles sem pedidos) usando a cláusula `WHERE p.id IS NULL`.

### 3. FULL OUTER JOIN: Reconciliação de dados

Útil para verificar inconsistências, garantindo que você veja todos os clientes e, simultaneamente, todos os pedidos (caso existissem pedidos sem clientes vinculados, seriam listados aqui).

```sql
SELECT c.nome, p.id AS pedido
FROM tb_clientes c
FULL OUTER JOIN tb_pedido p ON c.id = p.fk_cliente;

```
### 4. CROSS JOIN: Criando combinações

Se quisermos criar uma matriz de "Promoções de Natal" combinando todos os livros com todas as categorias de brinde (exemplo hipotético de tabela `brindes`):

```sql
SELECT l.titulo, b.nome AS brinde
FROM livros l
CROSS JOIN brindes b;

```
---

### Dicas de Ouro:

* **Aliases são essenciais:** Use abreviações (ex: `clientes c`) para tornar as consultas mais legíveis e evitar erros quando tabelas têm colunas com nomes iguais.


* **Performance:** `LEFT JOIN` é, muitas vezes, mais eficiente e legível do que usar `NOT EXISTS` para encontrar registros órfãos.


* **Cuidado com o CROSS JOIN:** Ele multiplica as linhas ($A \times B$). Em tabelas grandes, isso pode causar uma "explosão de dados".

Para realizar essa consulta com os novos nomes de tabela, precisamos unir as tabelas `livros` e `itens_pedido`. Como queremos o total por livro, utilizaremos a função `SUM` para a quantidade e o cálculo solicitado para o valor total de cada linha.

### Valor total vendido por item

```sql
SELECT 
    l.titulo,
    SUM(ip.quantidade) AS total_pedidos,
    (ip.quantidade * l.preco) AS valor_item
FROM livros l
INNER JOIN itens_pedido ip ON l.id = ip.fk_livro
GROUP BY l.titulo, ip.quantidade, l.preco;
```

* **`SUM(ip.quantidade)`**: Soma o total de unidades vendidas para aquele livro específico.

* **`ip.quantidade * l.preco`**: Calcula o valor total com base na quantidade de cada item e o preço unitário do livro.

* **`INNER JOIN`**: Garante que estamos relacionando os itens aos seus respectivos livros através das chaves correspondentes.

* **`GROUP BY`**: Como estamos usando funções de agregação (como o `SUM`), agrupamos pelas colunas não agregadas para que o banco de dados saiba como exibir os totais corretamente.

### outra requisição para somar os itens

```sql
SELECT 
    l.titulo,
    SUM(ip.quantidade) AS total_unidades_vendidas,
    SUM(ip.quantidade * l.preco) AS valor_total_arrecadado
FROM livros l
INNER JOIN itens_pedido ip ON l.id = ip.fk_livro
GROUP BY l.titulo;
```

`SUM(ip.quantidade * l.preco)` soma o valor de todos os pedidos onde aquele livro apareceu, o que costuma ser mais útil para relatórios de vendas.

---

### Valor total de cada pedido

Soma-se os preços de todos os itens associados a um pedido. Utilizar uma função de agregação `SUM` e agrupar os resultados pelo identificador do pedido (`pedidos.id`).

```sql
SELECT 
    p.id AS numero_pedido,
        SUM(ip.quantidade * l.preco) AS valor_total_pedido
        FROM pedidos p
        INNER JOIN itens_pedido ip ON p.id = ip.fk_pedido
        INNER JOIN livros l ON ip.fk_livro = l.id
        GROUP BY p.id
        ORDER BY p.id;
```

* **`p.id`**: Identifica o número único de cada pedido.
* **`SUM(ip.quantidade * l.preco)`**: Este é o núcleo da consulta. Para cada linha de item, ele multiplica a quantidade pelo preço do livro e, em seguida, o `SUM` soma esses resultados para todos os itens que pertencem ao mesmo `p.id`.
* **`INNER JOIN`**: Conecta os pedidos aos seus respectivos itens e, consequentemente, aos livros para buscar o preço unitário correto.
* **`GROUP BY p.id`**: Essencial para que o banco de dados calcule a soma individualmente para cada pedido, em vez de somar tudo em uma única linha.

---

### Dica extra: Exibir o nome do cliente

```sql
SELECT 
    p.id AS numero_pedido,
    c.nome AS cliente,
    SUM(ip.quantidade * l.preco) AS valor_total_pedido
FROM pedidos p
INNER JOIN clientes c ON p.fk_cliente = c.id
INNER JOIN itens_pedido ip ON p.id = ip.fk_pedido
INNER JOIN livros l ON ip.fk_livro = l.id
GROUP BY p.id, c.nome
ORDER BY p.id;
```