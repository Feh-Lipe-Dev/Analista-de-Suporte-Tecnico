
import java.util.Scanner;

public class InputDadosExerc {
  public static void main(String[] args) {

    String entrada = "";
    Integer inteiro = 0;
    Integer antes, depois = 0;

    Scanner input = new Scanner(System.in);

    boolean trueFalse = false;

    System.out.print("Digite um inteiro: ");
    entrada = input.next();

    while (!trueFalse) {
      try {
        inteiro = Integer.valueOf(entrada);
        if (inteiro instanceof Integer)
          trueFalse = true;
      } catch (NumberFormatException e) {
        System.out.print("Entrada inválida. Digite um inteiro: ");
        entrada = input.next();
      }
    }

    input.close();

    antes = inteiro - 1;
    depois = inteiro + 1;

    System.out.println("Número digitado: " + inteiro);
    System.out.println("Número anterior: " + antes);
    System.out.println("Número posterior: " + depois);
    // System.out.println(entrada.getClass().getSimpleName());
    // System.out.println(inteiro.getClass().getSimpleName());
  }
}