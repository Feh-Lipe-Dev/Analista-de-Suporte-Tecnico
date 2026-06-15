# Implementando Soft Delete

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

<img src="./img/soft-delete-alter.png" width="700" height="200">