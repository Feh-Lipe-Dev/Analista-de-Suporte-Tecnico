# 📚 Guia de Estudos: PostgreSQL

O documento reúne os comandos SQL praticados para a criação, manipulação e consulta do banco de dados. As instruções estão divididas por contexto, com explicações conceituais e os retornos esperados.

## SQL

A Linguagem de Consulta Estruturada (Structured Query Language) é a linguagem de programação padrão utilizada para se comunicar, gerenciar e manipular dados em bancos de dados relacionais.

Um banco de dados relacional é um sistema que armazena dados em tabelas bidimensionais (linhas e colunas), permitindo que diferentes conjuntos de informações sejam conectados entre si por meio de relacionamentos.

## PostgreSQL

O Postgres é um sistema de gerenciamento de banco de dados relacional e objeto (SGBDRO) de código aberto. Utilizado para armazenar, organizar e recuperar dados com segurança, sendo reconhecido por sua alta confiabilidade, desempenho e suporte estrito aos padrões técnicos

## Sublinguagens no SQL

O SQL é dividido em várias sublinguagens dentro do próprio sistema. Elas servem para organizar o trabalho com os dados.  
As principais são:

- DQL (Data Query Language): Para buscar e consultar dados. Ir para: [documento](./documentos/consulta-de-dados.md) ou [códigos](./códigos/consulta-de-dados.sql)
- DML (Data Manipulation Language): Para alterar o conteúdo das tabelas. Ir para [documento](./documentos/manipulacao-de-dados.md) ou [códigos](./códigos/manipulacao-de-dados.sql).
- DDL (Data Definition Language): Para criar ou mudar a estrutura do banco. Ir para [documento](./documentos/definicao-de-dados.md) ou [códigos](./códigos/definicao-de-dados.sql).
- DCL (Data Control Language): Para controlar quem tem acesso ao banco.
- DTL (Data Transaction Language): Para salvar ou cancelar alterações.

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

Saída esperada: Tabela criada com sucesso (CREATE TABLE).

~~~~sql
| id | nome | email | senha | criado_em | atualizado_em |
~~~~

COMMENT ON: Adiciona uma descrição/metadado à tabela.  

~~~~sql
COMMENT ON TABLE tb_cliente IS 'tabela dos clientes da livrariaSCTEC';
~~~~

## Inserção de Dados (DML - Data Manipulation Language)

Para inserir dados em uma tabela, utilizamos o comando `INSERT INTO`. Ele permite adicionar novas linhas com os valores correspondentes para cada coluna.

~~~~sql
INSERT INTO tb_cliente (nome, email, senha) VALUES
('Fulano', 'fulano1990@ig.com.br', '9987ffrr*bt+/'),
('Beltrano', 'tiobeltrano@ig.com.br', '54hrrr*bt+/'),
('Ciclano', 'lojaclicano@ig.com.br', '54hr!#@tth'),
('Fulaninha', 'makeful@ig.com.br', '54/rg4*74vD');
~~~~

Saída esperada: INSERT 0 4 (indicando que 4 registros foram inseridos com sucesso).

## Consultas de Dados (DQL - Data Query Language)

Comandos básicos para recuperar informações do banco de dados:

- O `SELECT` é a base para todas as consultas, permitindo projetar colunas específicas, filtrar resultados e realizar operações de junção entre tabelas.
- O `WHERE` é utilizado para filtrar os resultados com base em condições específicas.
- O `LIMIT` restringe o número de linhas retornadas pela consulta.
- O `ORDER BY` ordena os resultados com base em uma ou mais colunas, podendo ser em ordem crescente (ASC) ou decrescente (DESC).

Consulta básica para exibir os clientes cadastrados:

~~~~sql
SELECT * FROM tb_cliente LIMIT 2;
~~~~

Retorna todos os campos da tabela, mas restringe o resultado às 2 primeiras linhas através do LIMIT.  
SAÍDA: (Tabela):

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

### Criação de mais tabelas, relacionamentos e consultas avançadas

~~~~sql
CREATE TABLE tb_livro(
  id SERIAL PRIMARY KEY,
  titulo VARCHAR(200) NOT NULL,
  dt_publicacao DATE NOT NULL,
  preco NUMERIC(10, 2) NOT NULL,
  criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO tb_livro (titulo, dt_publicacao, preco) VALUES
('O Senhor dos anéis: sociedade do anel', '1954-06-29', 79.90),
('O Senhor dos anéis: as duas torres', '1955-07-28', 89.98),
('O Senhor dos anéis: o retorno do rei', '1956-08-27', 99.99),
('Box As crônicas de Nárnia: Edição de luxo', '2024-03-02', 297.84),
('O Hobbit', '1960-04-23', 104.32);
~~~~

## Atualização de Dados (DML - Data Manipulation Language)

`UPDATE` é o comando utilizado para modificar os dados existentes em uma tabela. Ele permite alterar valores específicos com base em condições definidas na cláusula `WHERE`.

~~~~sql
UPDATE tb_livro SET preco = preco - (preco * 0.15) WHERE tb_livro.id = 4;

SELECT * FROM tb_livro WHERE tb_livro.id = 4;
~~~~

Função e saída: Aplica um desconto de 15% no preço do livro com id = 4 (Box As crônicas de Nárnia), e seleção com filtro para exibir o novo preço.

| id | titulo | dt_publicacao | preco | criado_em | atualizado_em |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 4 | Box As crônicas de Nárnia: Edição de luxo | 2024-03-02 | 253.16 | 2026-06-14 19:56:12 | 2026-06-14 19:56:12 |

## Consultas Agregadoras (DQL - Data Query Language)

Ir para: [documento sobre DQL](./documentos/consulta-de-dados.md) ou [códigos](./códigos/consulta-de-dados.sql).

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

| total_estoque | media_estoque |
| :--- | :--- |
| 627.35 | 125.47 |

## Relacionamento entre Tabelas: chave estrangeira (FOREIGN KEY)

Ir para: [documento chave estrangeira](./documentos/chave-estrangeira.md) ou [códigos](./códigos/definicao-de-dados.sql).

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

### Criação de FOREIGN KEY e Regras de Integridade no PostgreSQL

Explicando os elementos do código acima:

- `fk_cliente INTEGER NOT NULL`: Define a coluna fk_cliente como um inteiro que não pode ser nulo, indicando que cada pedido deve estar associado a um cliente.
- `CONSTRAINT fk_pedido_cliente`: Nomeia a restrição de chave estrangeira para facilitar a identificação e manutenção do banco de dados.
- `FOREIGN KEY (fk_cliente) REFERENCES tb_cliente(id)`: Estabelece que fk_cliente é uma chave estrangeira que referencia a coluna id da tabela tb_cliente, criando um vínculo de integridade referencial.
- `ON DELETE CASCADE`: Especifica que, se um cliente for excluído do sistema, todos os seus pedidos serão removidos automaticamente, evitando registros órfãos.

SAÍDA: CREATE TABLE

### Inserção de pedidos

Para criar um pedido, é necessário associá-lo a um cliente existente através do campo fk_cliente, que é uma chave estrangeira referenciando a tabela de clientes.

~~~~sql
INSERT INTO tb_pedido (fk_cliente) VALUES (1); -- Pedido para o cliente com id = 1 (Fulano)
INSERT INTO tb_pedido (fk_cliente) VALUES (4); -- Pedido para o cliente com id = 4 (Fulaninha)
INSERT INTO tb_pedido (fk_cliente) VALUES (3); -- Pedido para o cliente com id = 3 (Ciclano)
~~~~

## Consulta Relacional com Junção de Tabelas - JOINs

É possível realizar consultas que cruzam dados de múltiplas tabelas utilizando JOINs.  
O INNER JOIN retorna apenas as linhas que possuem correspondência em ambas as tabelas.

~~~~sql
SELECT tb_pedido.id AS num_Pedido, tb_cliente.nome, tb_cliente.email,
tb_pedido.fk_cliente AS id_cliente
FROM tb_cliente INNER JOIN tb_pedido ON tb_cliente.id = tb_pedido.fk_cliente;
~~~~

Realiza um INNER JOIN para cruzar dados de pedidos e clientes, exibindo quem realizou cada compra e criando apelidos (AS) para melhor legibilidade das colunas. SAÍDA:

| num_Pedido | nome | email | id_cliente |
| :--- | :--- | :--- | :--- |
| 1 | Fulano | fulano1990@ig.com.br | 1 |
| 2 | Fulaninha | makeful@ig.com.br | 4 |
| 3 | Ciclano | lojaclicano@ig.com.br | 3 |

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
Saída esperada: CREATE TABLE.

Inserção de Dados (DML)

~~~~sql
INSERT INTO tb_itens_pedido (quantidade, fk_livro, fk_pedido) VALUES
(2, 2, 1),
(3, 3, 3),
(1, 4, 2);
~~~~

## Consultas Complexas com Cálculos e Ordenação (DQL)

Ir para: [documento sobre cálculos](./documentos/calculos-ordenacao.md) ou [códigos](./códigos/consulta-de-dados.sql)

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
Saída esperada (Tabela):
| preco | num_Pedido | menor_maior |
| :--- | :--- | :--- |
| 89.98 | 1 | 179.96 |
| 253.16 | 2 | 253.16 |
| 99.99 | 3 | 299.97 |

## Implementando Soft Delete

Ir para: [documento soft delete](./documentos/exclusao-logica.md) ou [códigos](./códigos/definicao-de-dados.sql).

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
