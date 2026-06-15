SELECT * FROM tb_cliente LIMIT 2;

SELECT tb_cliente.nome, tb_cliente.email FROM tb_cliente;

SELECT * FROM tb_livro WHERE tb_livro.id = 4;

SELECT ROUND(SUM(tb_livro.preco), 2) AS total_estoque,
ROUND(AVG(tb_livro.preco), 2) AS media_estoque FROM tb_livro;

SELECT tb_pedido.id AS num_Pedido, tb_cliente.nome, tb_cliente.email,
tb_pedido.fk_cliente AS id_cliente
FROM tb_cliente INNER JOIN tb_pedido ON tb_cliente.id = tb_pedido.fk_cliente;

SELECT tb_itens_pedido.fk_pedido As numPedido, tb_livro.id AS livro_id, tb_livro.titulo,
tb_livro.preco, tb_itens_pedido.quantidade, tb_livro.preco * tb_itens_pedido.quantidade AS total
FROM tb_livro
INNER JOIN tb_itens_pedido ON tb_livro.id = tb_itens_pedido.fk_livro;

SELECT tb_livro.preco, tb_itens_pedido.fk_pedido AS num_Pedido,
tb_livro.preco * tb_itens_pedido.quantidade AS menor_maior
FROM tb_livro
INNER JOIN tb_itens_pedido ON tb_livro.id = tb_itens_pedido.fk_livro
ORDER BY menor_maior ASC;
