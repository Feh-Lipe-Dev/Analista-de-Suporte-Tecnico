# JOIN

## Por que precisamos?

JOIN combina linhas de duas ou mais tabelas com base em uma condição de relacionamento (geralmente FK → PK). Sem JOINs, precisaríamos de queries separadas e juntar os dados na aplicação — o que seria lento e frágil.

## Tipo de JOIN

| Tipo/sintaxe | Descrição |
|--------------|-----------| 
| `INNER JOIN` | Retorna apenas as linhas que possuem correspondência em ambas as tabelas |
| `LEFT JOIN` | Retorna todas as linhas da tabela da esquerda e, se não houver correspondência, preenche com NULL |
| `RIGHT JOIN` |Retorna todas as linhas da tabela da direita e, se não houver correspondência, preenche com NULL |
| `FULL JOIN` | Retorna todas as linhas de ambas as tabelas, preenchendo com NULL onde não há correspondência |
| `CROSS JOIN` |Realiza o produto cartesiano (todas as combinações possíveis entre linhas das duas tabelas) |