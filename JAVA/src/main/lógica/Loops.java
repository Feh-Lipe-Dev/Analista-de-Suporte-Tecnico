
public class Loops {
  public static void main(String[] args) {
    // FOR
    // for (inicialização; condição; incremento)
    System.out.println("Loop FOR");
    for (int i = 0; i < 4; i++) {
      System.out.println("i = " + i);
    }
    System.out.println("");

    // WHILE
    // while (condição)
    System.out.println("Loop WHILE");
    int j = 0;
    while (j < 4) {
      System.out.println("j = " + j);
      j++;
    }
    System.out.println("");

    // DO WHILE
    // do (executa o bloco de código pelo menos uma vez)
    // while (condição)
    System.out.println("Loop DO WHILE");
    int k = 0;
    do {
      System.out.println("k = " + k);
      k++;
    } while (k < 4);
    System.out.println("");

    // FOREACH
    // for (tipo variável : array)
    // O loop for-each é usado para percorrer elementos de um array ou uma coleção.
    // Ele é mais simples e legível do que o loop for tradicional,
    // quando você não precisa do índice do elemento.
    System.out.println("Loop FOREACH");
    int[] numeros = { 1, 2, 3 };
    int count = 0;
    for (int numero : numeros) {
      System.out.printf("posição %d, valor %d\n", count, numero);
      count++;
    }
  }
}