# Consultas de Dados (DQL - Data Query Language)

DQL é a parte da linguagem SQL que se concentra na recuperação de dados do banco de dados. Ela inclui comandos que permitem selecionar, filtrar, ordenar e limitar os resultados das consultas.

## Comandos básicos para recuperar informações do banco de dados

- O `SELECT` é a base para todas as consultas, permitindo projetar colunas específicas, filtrar resultados e realizar operações de junção entre tabelas.
- O `WHERE` é utilizado para filtrar os resultados com base em condições específicas.
- O `LIMIT` restringe o número de linhas retornadas pela consulta.
- O `ORDER BY` ordena os resultados com base em uma ou mais colunas, podendo ser em ordem crescente (ASC) ou decrescente (DESC).

Consulta básica para exibir os clientes cadastrados:

~~~~sql
SELECT * FROM tb_cliente LIMIT 2;
~~~~

Retorna todos os campos da tabela, mas restringe o resultado às 2 primeiras linhas através do LIMIT.  
SAÍDA:

| id | nome | email | senha | criado_em | atualizado_em |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | Fulano | fulano1990@ig.com.br | 9987ffrrbt+/ | 2026-06-14 19:56:12 | 2026-06-14 19:56:12 |
| 2 | Beltrano | tiobeltrano@ig.com.br | 54hrrrbt+/ | 2026-06-14 19:56:12 | 2026-06-14 19:56:12 |

~~~~sql
SELECT tb_cliente.nome, tb_cliente.email FROM tb_cliente;
~~~~

SAÍDA: apenas as colunas específicas de nome e e-mail de todos os clientes.

| nome | email |
| :--- | :--- |
| Fulano | fulano1990@ig.com.br |
| Beltrano | tiobeltrano@ig.com.br |
| Ciclano | lojaclicano@ig.com.br |
| Fulaninha | makeful@ig.com.br |

## Consultas Agregadoras (DQL - Data Query Language)

Consultas que utilizam funções agregadoras para realizar cálculos sobre um conjunto de dados, como soma, média, contagem, etc.  
Alguns comandos comuns incluem:

- `SUM()`: Calcula a soma total de uma coluna numérica.
- `AVG()`: Calcula a média de uma coluna numérica.
- `COUNT()`: Conta o número de linhas ou valores distintos em uma coluna.
- `MAX()`: Retorna o valor máximo de uma coluna.
- `MIN()`: Retorna o valor mínimo de uma coluna.
- `ROUND()`: Arredonda um número para um número específico de casas decimais.

~~~~sql
SELECT ROUND(SUM(tb_livro.preco), 2) AS total_estoque,
ROUND(AVG(tb_livro.preco), 2) AS media_estoque FROM tb_livro;
~~~~

Função e saída: Utiliza as funções agregadoras SUM (Soma) e AVG (Média) combinadas com a função ROUND para limitar o resultado a 2 casas decimais.

<img src="./img/total-media-estoque.png" width="520" height="220">

## Consulta Relacional com Junção de Tabelas - JOINs

É possível realizar consultas que cruzam dados de múltiplas tabelas utilizando JOINs.  
O INNER JOIN retorna apenas as linhas que possuem correspondência em ambas as tabelas.

~~~~sql
SELECT tb_pedido.id AS num_Pedido, tb_cliente.nome, tb_cliente.email,
tb_pedido.fk_cliente AS id_cliente
FROM tb_cliente INNER JOIN tb_pedido ON tb_cliente.id = tb_pedido.fk_cliente;
~~~~

Realiza um INNER JOIN para cruzar dados de pedidos e clientes, exibindo quem realizou cada compra e criando apelidos (AS) para melhor legibilidade das colunas. SAÍDA:

<img src="./img/inner-join.png" width="550" height="250">

## Consultas Complexas com Cálculos e Ordenação (DQL)

~~~~sql
SELECT tb_itens_pedido.fk_pedido As numPedido, tb_livro.id AS livro_id, tb_livro.titulo,
tb_livro.preco, tb_itens_pedido.quantidade, tb_livro.preco * tb_itens_pedido.quantidade AS total
FROM tb_livro
INNER JOIN tb_itens_pedido ON tb_livro.id = tb_itens_pedido.fk_livro;
~~~~

Função: Junta a tabela de livros com seus itens correspondentes e faz uma operação aritmética (preco * quantidade) em tempo de execução para gerar o subtotal de cada item.  
Saída esperada (Tabela):

| numPedido | livro_id | titulo | preco | quantidade | total |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 2 | O Senhor dos anéis: as duas torres | 89.98 | 2 | 179.96 || 3 | 3 | O Senhor dos anéis: o retorno do rei | 99.99 | 3 | 299.97 || 2 | 4 | Box As crônicas de Nárnia... | 253.16 | 1 | 253.16 |

~~~~sql
SELECT tb_livro.preco, tb_itens_pedido.fk_pedido AS num_Pedido,
tb_livro.preco * tb_itens_pedido.quantidade AS menor_maior
FROM tb_livro
INNER JOIN tb_itens_pedido ON tb_livro.id = tb_itens_pedido.fk_livro
ORDER BY menor_maior ASC;
~~~~

Função: Similar à anterior, mas utiliza a cláusula ORDER BY ... ASC para ordenar o resultado final com base no valor calculado (do menor para o maior total).  

<img src="./img/menor-maior.png" width="550" height="250">
