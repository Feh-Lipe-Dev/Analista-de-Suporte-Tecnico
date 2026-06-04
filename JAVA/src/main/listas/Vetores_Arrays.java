
import java.util.Scanner;

// VETORES / ARRAYS
// São estruturas de dados que armazenam uma coleção de elementos do mesmo tipo.
// Cada elemento é acessado por um índice numérico, começando geralmente em 0.
// Os vetores têm um tamanho fixo, definido na sua criação.
// O tamanho de um vetor é imutável após a sua criação (não aumenta ou diminui dinamicamente)
// Em Java, os vetores são implementados como arrays.

public class Vetores_Arrays {
    public static void main(String[] args) {

        // Declaração e inicialização de um vetor de inteiros com tamanho 3
        int[] nums = new int[3];
        nums[0] = 5; // Atribuição de valores aos elementos do vetor
        nums[1] = 10;
        nums[2] = 15;
        int soma = 0;

        // Iteração sobre o vetor usando um loop for
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Index: " + i + " / valor: " + nums[i] + ".");
            soma += nums[i];
        }
        System.out.println("Soma da lista nums = " + soma + ".\n");

        // é possível "reinicializar" o vetor com um novo tamanho
        // O vetor não é redimensionado, mas sim substituído por um novo
        // Declare a variável correspondente ao Array e use o operador new
        // para criar um novo vetor com o tamanho desejado.
        // Para inicializar um vetor com valores
        // pode-se usar a sintaxe abaixo, usando um par de chaves:
        nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Novo vetor nums: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println("\n");

        // Declaração e inicialização de um vetor de strings
        String[] itens = new String[] {
                "papel", "lapis", "caneta"
        };
        System.out.println("Vetor itens: ");
        int i = 0;
        while (i < itens.length) {
            System.out.print(itens[i] + ", ");
            i++;
        }
        System.out.println("\n");
        // Sinatxe de Array sem o uso do operador new
        String[] itens2 = { "caderno", "borracha", "régua" };

        String[] itens3 = new String[3];
        Scanner scanner = new Scanner(System.in);
        for (int count = 0; i < 3; i++) {
            System.out.println("Digite o item " + (count + 1) + ": ");
            itens3[count] = scanner.nextLine();
        }
        scanner.close();
        System.out.println("Itens cadastrados:");
        int countIntens = 1;
        for (String inputItens : itens3) {
            System.out.printf("Item %d: %s\n", countIntens, inputItens);
            countIntens++;
        }
    }
}