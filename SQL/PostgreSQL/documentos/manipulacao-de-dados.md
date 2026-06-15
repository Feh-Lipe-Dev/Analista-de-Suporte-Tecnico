# Manipulação de Dados em PostgreSQL (DML - Data Manipulation Language)

Os dados em um banco de dados são manipulados utilizando a linguagem DML (Data Manipulation Language). Ela inclui comandos para inserir, atualizar, excluir e consultar dados. A seguir, veremos como realizar essas operações básicas em PostgreSQL.

Coamndos DML comuns incluem:

- `INSERT INTO`: para inserir novos registros em uma tabela.
- `UPDATE`: para atualizar registros existentes.
- `DELETE`: para excluir registros de uma tabela.
- `TRUNCATE`: para remover todos os registros de uma tabela, mas mantendo sua estrutura.

## Inserção de Dados

Para inserir dados em uma tabela, utilizamos o comando `INSERT INTO`. Ele permite adicionar novas linhas com os valores correspondentes para cada coluna.

~~~~sql
INSERT INTO tb_cliente (nome, email, senha) VALUES
('Fulano', 'fulano1990@ig.com.br', '9987ffrr*bt+/'),
('Beltrano', 'tiobeltrano@ig.com.br', '54hrrr*bt+/'),
('Ciclano', 'lojaclicano@ig.com.br', '54hr!#@tth'),
('Fulaninha', 'makeful@ig.com.br', '54/rg4*74vD');
~~~~

<img src="/SQL/PostgreSQL/img/tb_cliente-insert.png" width="550" height="250">  

---
  
`UPDATE` é o comando utilizado para modificar os dados existentes em uma tabela. Ele permite alterar valores específicos com base em condições definidas na cláusula `WHERE`.

~~~~sql
UPDATE tb_livro SET preco = preco - (preco * 0.15) WHERE tb_livro.id = 4;

SELECT * FROM tb_livro WHERE tb_livro.id = 4;
~~~~

Função e saída: Aplica um desconto de 15% no preço do livro com id = 4 (Box As crônicas de Nárnia), e seleção com filtro para exibir o novo preço.

<img src="/SQL/PostgreSQL/img/update.png" width="550" height="250">

---

Criando pedidos na tabela:

~~~~sql
INSERT INTO tb_pedido (fk_cliente) VALUES (1); -- Pedido para o cliente com id = 1 (Fulano)
INSERT INTO tb_pedido (fk_cliente) VALUES (4); -- Pedido para o cliente com id = 4 (Fulaninha)
INSERT INTO tb_pedido (fk_cliente) VALUES (3); -- Pedido para o cliente com id = 3 (Ciclano)
~~~~

Inserção de itens:

~~~~sql
INSERT INTO tb_itens_pedido (quantidade, fk_livro, fk_pedido) VALUES
(2, 2, 1),
(3, 3, 3),
(1, 4, 2);
~~~~

Função: Vincula livros específicos e suas quantidades aos pedidos criados.
