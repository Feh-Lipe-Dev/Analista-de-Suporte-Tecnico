
// ARRAYS MULTIDIMENSIONAIS
// São estruturas de dados que armazenam uma coleção de elementos do mesmo tipo em múltiplas dimensões.
// Cada elemento é acessado por um conjunto de índices, um para cada dimensão.
// Os arrays multidimensionais têm um tamanho fixo, definido na sua criação e são imutáveis.
// Em Java, os arrays multidimensionais são implementados como arrays de arrays.
// Exemplo de um array bidimensional (matriz)
// int[][] matriz = new int[3][3]; int[][][] e assim por diante

public class ArraysMult {
    public static void main(String[] args) {
        // Sintaxe da declaração e inicialização
        // sintaxe da atribuição de valores
        String trim01[][] = new String[2][3];
        trim01[0][0] = "Janeiro";
        trim01[0][1] = "Fevereiro";
        trim01[0][2] = "Março";
        trim01[1][0] = "31 dias";
        trim01[1][1] = "28 dias";
        trim01[1][2] = "31 dias";
        // trim01[0][0] -> a 1ª posição (dimensão) contém o registro na memória do array
        // trim01[0][0] -> a 2ª posição (dimensão) contém o valor do elemento
        // trim01[0] = @24d46ca6 trim01[0][0] -> "Janeiro"

        System.out.println("1º trimestre:");
        for (int linha = 0; linha < trim01.length; linha++) {
            for (int coluna = 0; coluna < trim01[linha].length; coluna++) {
                System.out.println("Mês: " + trim01[linha][coluna] + ", " + trim01[linha + 1][coluna]);
                System.out.println("Valor de trim01[linha][coluna]: " + trim01[linha][coluna]);
            }
        }
        // para percorrer um array multidimensional com foreach,
        // é necessário usar um loop for aninhado
        // para cada linha do array, percorrer cada coluna da linha
        // para cada coluna da linha, imprimir o valor da coluna
        // o tipo da variável de controle do loop for deve ser o mesmo tipo do array.
        // Ex: String[] linha
        System.out.println(" ");
        System.out.println("Usando foreach:");
        System.out.println(" ");
        // arrayBase é uma variável de controle do loop for
        // arrayBase vai atribuir ter os valores das linhas
        // o 2º forEach vai percorrer cada coluna da linha
        for (String[] arrayBase : trim01) {
            for (String valor : arrayBase) {
                System.out.println(valor);
            }
        }
    }
}