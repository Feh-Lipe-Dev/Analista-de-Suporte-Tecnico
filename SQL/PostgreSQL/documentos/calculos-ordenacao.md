# Consultas Complexas com Cálculos e Ordenação

~~~~sql
SELECT tb_itens_pedido.fk_pedido As numPedido,
tb_livro.id AS livro_id, 
tb_livro.titulo, tb_livro.preco, tb_itens_pedido.quantidade,
tb_livro.preco * tb_itens_pedido.quantidade AS total
FROM tb_livro
INNER JOIN tb_itens_pedido ON tb_livro.id = tb_itens_pedido.fk_livro;
~~~~

Função: Junta a tabela de livros com seus itens correspondentes e faz uma operação aritmética (preco * quantidade) em tempo de execução para gerar o subtotal de cada item.  

<img src="/SQL/PostgreSQL/img/itens-pedido-total.png" width="550" height="250">
