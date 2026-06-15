# Relacionamento entre Tabelas: chave estrangeira (FOREIGN KEY)

Chaves estrangeiras são usadas para estabelecer um vínculo entre duas tabelas, garantindo a integridade referencial. Elas indicam que um campo em uma tabela é uma referência a um campo em outra tabela, geralmente a chave primária.

~~~~sql
CREATE TABLE tb_pedido(
  id SERIAL PRIMARY KEY,
  data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fk_cliente INTEGER NOT NULL,

  CONSTRAINT fk_pedido_cliente
    FOREIGN KEY (fk_cliente)
    REFERENCES tb_cliente(id)
    ON DELETE CASCADE
);
~~~~

## Criação de FOREIGN KEY e Regras de Integridade no PostgreSQL

As chaves estrangeiras são definidas usando a cláusula `FOREIGN KEY` dentro da declaração de criação da tabela. No exemplo acima, a coluna `fk_cliente` é definida como uma chave estrangeira que referencia a coluna `id` da tabela `tb_cliente`. A cláusula `ON DELETE CASCADE` garante que, se um cliente for excluído, todos os pedidos associados a esse cliente também serão removidos automaticamente, mantendo a integridade dos dados.

Mais detalhes sobre os componentes da criação da chave estrangeira:

- `fk_cliente INTEGER NOT NULL`: Define a coluna fk_cliente como um inteiro que não pode ser nulo, indicando que cada pedido deve estar associado a um cliente.
- `CONSTRAINT fk_pedido_cliente`: Nomeia a restrição de chave estrangeira para facilitar a identificação e manutenção do banco de dados.
- `FOREIGN KEY (fk_cliente) REFERENCES tb_cliente(id)`: Estabelece que fk_cliente é uma chave estrangeira que referencia a coluna id da tabela tb_cliente, criando um vínculo de integridade referencial.
- `ON DELETE CASCADE`: Especifica que, se um cliente for excluído do sistema, todos os seus pedidos serão removidos automaticamente, evitando registros órfãos.

SAÍDA: CREATE TABLE

Criação da Tabela (DDL) dos itens do pedido:

~~~~sql
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
~~~~

<img src="./img/foreign-key.png" width="550" height="250">


**Detalhes da chave primária e estrangeiras de tb_itens_pedido:**

- `PRIMARY KEY (fk_livro, fk_pedido)`: Define uma chave primária composta, garantindo que a combinação de fk_livro e fk_pedido seja única, evitando que o mesmo livro seja adicionado em linhas separadas no mesmo pedido.
- `FOREIGN KEY (fk_livro) REFERENCES tb_livro(id) ON DELETE CASCADE`: Estabelece que fk_livro é uma chave estrangeira que referencia a coluna id da tabela tb_livro, garantindo que cada item do pedido esteja associado a um livro válido. A cláusula ON DELETE CASCADE assegura que, se um livro for excluído, os itens de pedido relacionados também serão removidos.
- `FOREIGN KEY (fk_pedido) REFERENCES tb_pedido(id) ON DELETE CASCADE`: Estabelece que fk_pedido é uma chave estrangeira que referencia a coluna id da tabela tb_pedido, garantindo que cada item do pedido esteja associado a um pedido válido. A cláusula ON DELETE CASCADE assegura que, se um pedido for excluído, os itens de pedido relacionados também serão removidos.
