# Definição de Dados (Data Definition Language - DDL)

Comandos DDL são utilizados para definir a estrutura do banco de dados, incluindo a criação, alteração e exclusão de tabelas e outros objetos. Eles são essenciais para estabelecer a organização dos dados e garantir a integridade do banco.

**BD CRIADO NO pgAdmin**

<img src="/SQL/PostgreSQL/img/create-database.png" width="650" height="350">

## Criação de Tabelas (DDL - Data Definition Language)

`CREATE TABLE` é o comando utilizado para criar uma nova tabela dentro do banco de dados. Ele define a estrutura da tabela, incluindo os nomes das colunas, tipos de dados e restrições.  

~~~~sql
CREATE TABLE tb_cliente(
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(150) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL,
  criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
~~~~

Explicando em detalhes a sintaxe de uma das linhas do código abaixo:  

`nome VARCHAR(100) NOT NULL,`

- `nome`: Nome da coluna que armazenará os nomes dos clientes.
- `VARCHAR(100)`: Tipo de dado que indica que a coluna armazenará cadeias de caracteres (strings) com um comprimento máximo de 100 caracteres.
- `NOT NULL`: Restrição que garante que essa coluna não pode conter valores nulos, ou seja, é obrigatório preencher o nome do cliente.

### Conceitos Importantes: RESTRIÇÕES e TIPOS DE DADOS

- VARCHAR: Tipo de dado para armazenar texto. O número entre parênteses define o tamanho máximo da string.
- TIMESTAMP: Tipo de dado para armazenar data e hora. Útil para registrar quando um cliente foi criado ou atualizado.
- INTEGER: Tipo de dado para armazenar números inteiros, usado para chaves estrangeiras (fk_cliente).
- NUMERIC(10, 2): Tipo de dado para armazenar valores monetários, garantindo precisão decimal.
- BOOLEAN: Tipo de dado para armazenar valores booleanos (true/false), utilizado para a flag de exclusão lógica (ativo).
- FOREIGN KEY: Define uma chave estrangeira, criando um vínculo entre tabelas para garantir a integridade referencial.
- CONSTRAINT: Permite nomear restrições, facilitando a identificação e manutenção do banco de dados.
- SERIAL: Cria uma coluna de inteiros auto-incrementada (gerada automaticamente pelo banco).
- PRIMARY KEY: Define a chave primária, garantindo que o id seja único e não nulo.
- UNIQUE: Restrição que impede emails duplicados no sistema.
- NOT NULL: Torna o preenchimento do campo obrigatório.
- DEFAULT CURRENT_TIMESTAMP: Insere a data e hora atual do servidor caso nenhum valor seja passado.
- ON DELETE CASCADE: Especifica que, se um registro na tabela referenciada for excluído, os registros relacionados na tabela atual também serão excluídos automaticamente.
- ALTER TABLE: Comando utilizado para modificar a estrutura de uma tabela existente, como adicionar ou remover colunas, ou alterar restrições.

Saída esperada: Tabela criada com sucesso (CREATE TABLE).

~~~~sql
| id | nome | email | senha | criado_em | atualizado_em |
~~~~

~~~~sql
-- COMMENT ON: Adiciona uma descrição/metadado à tabela.  
COMMENT ON TABLE tb_cliente IS 'tabela dos clientes da livrariaSCTEC';
~~~~

Saída esperada: Comentário adicionado com sucesso (COMMENT ON).

~~~~sql
-- Tabela livro
CREATE TABLE tb_livro(
  id SERIAL PRIMARY KEY,
  titulo VARCHAR(200) NOT NULL,
  dt_publicacao DATE NOT NULL,
  preco NUMERIC(10, 2) NOT NULL,
  criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
~~~~

<img src="/SQL/PostgreSQL/img/tb-livro.png" width="600" height="300">

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

Importante:PRIMARY KEY (fk_livro, fk_pedido): Define uma Chave Primária Composta. Isso impede que o mesmo livro seja adicionado em linhas separadas no mesmo pedido.  
Saída esperada: CREATE TABLE

## Implementando Soft Delete

Soft Delete (Exclusão Lógica) é um padrão de projeto onde registros não são apagados fisicamente do banco de dados (evitando perda de histórico). Em vez disso, uma flag booleana indica se o registro está ativo ou oculto para o usuário final.  
Modificação de estrutura: (DDL)

~~~~sql
ALTER TABLE tb_cliente ADD COLUMN ativo BOOLEAN DEFAULT true;
~~~~

Função: Modifica a estrutura de tb_cliente para adicionar a flag de estado ativo.  Classificação: DDL.  
Saída esperada: A tabela de clientes agora exibe uma nova coluna ativo, preenchida automaticamente com true para todos os registros anteriores.

~~~~sql
-- incluindo a mesma lógica de exclusão lógica.
ALTER TABLE tb_livro ADD COLUMN ativo BOOLEAN DEFAULT true;
~~~~
