INSERT INTO tb_cliente (nome, email, senha) VALUES
('Fulano', 'fulano1990@ig.com.br', '9987ffrr*bt+/'),
('Beltrano', 'tiobeltrano@ig.com.br', '54hrrr*bt+/'),
('Ciclano', 'lojaclicano@ig.com.br', '54hr!#@tth'),
('Fulaninha', 'makeful@ig.com.br', '54/rg4*74vD');

INSERT INTO tb_livro (titulo, dt_publicacao, preco) VALUES
('O Senhor dos anéis: sociedade do anel', '1954-06-29', 79.90),
('O Senhor dos anéis: as duas torres', '1955-07-28', 89.98),
('O Senhor dos anéis: o retorno do rei', '1956-08-27', 99.99),
('Box As crônicas de Nárnia: Edição de luxo', '2024-03-02', 297.84),
('O Hobbit', '1960-04-23', 104.32);

UPDATE tb_livro SET preco = preco - (preco * 0.15) WHERE tb_livro.id = 4;

INSERT INTO tb_pedido (fk_cliente) VALUES (1); -- Pedido para o cliente com id = 1 (Fulano)
INSERT INTO tb_pedido (fk_cliente) VALUES (4); -- Pedido para o cliente com id = 4 (Fulaninha)
INSERT INTO tb_pedido (fk_cliente) VALUES (3); -- Pedido para o cliente com id = 3 (Ciclano)

INSERT INTO tb_itens_pedido (quantidade, fk_livro, fk_pedido) VALUES
(2, 2, 1),
(3, 3, 3),
(1, 4, 2);
