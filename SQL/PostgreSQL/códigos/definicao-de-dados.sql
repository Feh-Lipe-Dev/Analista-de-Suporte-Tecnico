CREATE TABLE tb_cliente(
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(150) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL,
  criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- COMMENT ON: Adiciona uma descrição/metadado à tabela.  
COMMENT ON TABLE tb_cliente IS 'tabela dos clientes da livrariaSCTEC';

CREATE TABLE tb_livro(
  id SERIAL PRIMARY KEY,
  titulo VARCHAR(200) NOT NULL,
  dt_publicacao DATE NOT NULL,
  preco NUMERIC(10, 2) NOT NULL,
  criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- FOREIGN KEY
-- Tabela de pedidos, relacionando clientes e livros através de chaves estrangeiras.
CREATE TABLE tb_pedido(
  id SERIAL PRIMARY KEY,
  data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fk_cliente INTEGER NOT NULL,

  CONSTRAINT fk_pedido_cliente
    FOREIGN KEY (fk_cliente)
    REFERENCES tb_cliente(id)
    ON DELETE CASCADE
);

CREATE TABLE tb_itens_pedido(
  quantidade INTEGER NOT NULL,
  fk_livro INTEGER NOT NULL,
  fk_pedido INTEGER NOT NULL,

  CONSTRAINT pk_itens_pedido
    PRIMARY KEY (fk_livro, fk_pedido),

  CONSTRAINT fk_itens_livro
    FOREIGN KEY (fk_livro)
    REFERENCES tb_livro(id)
    ON DELETE CASCADE,

  CONSTRAINT fk_itens_pedido
    FOREIGN KEY (fk_pedido)
    REFERENCES tb_pedido(id)
    ON DELETE CASCADE
);

ALTER TABLE tb_cliente ADD COLUMN ativo BOOLEAN DEFAULT true;

-- incluindo a mesma lógica de exclusão lógica.
ALTER TABLE tb_livro ADD COLUMN ativo BOOLEAN DEFAULT true;
