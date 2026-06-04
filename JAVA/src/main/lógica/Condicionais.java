
import java.util.Scanner;

public class Condicionais {
  public static void main(String[] args) {
    // IF
    int idade = 18;
    if (idade >= 18) {
      System.out.println("Maior de idade");
    }
    // IF ELSE
    if (idade >= 18) {
      System.out.println("Maior de idade");
    } else {
      System.out.println("Menor de idade");
    }

    // IF ELSE IF
    if (idade >= 18) {
      System.out.println("Maior de idade");
    } else if (idade >= 16) {
      System.out.println("Menor de idade, mas pode votar");
    } else {
      System.out.println("Menor de idade");
    }

    // TERNÁRIO
    int idade2 = 18;
    String resultado = (idade2 >= 18) ? "Maior de idade" : "Menor de idade";
    System.out.println(resultado);
    // ou
    System.out.println((idade2 >= 18) ? "Maior de idade" : "Menor de idade");

    // SWITCH
    int dia = 0;
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("Dia da semana (de 1 a 7): ");
      String scan = scanner.nextLine();
      System.out.println(" ");
      dia = Integer.parseInt(scan);
      switch (dia) {
        case 1:
          System.out.println("Dia " + dia + " = Domingo");
          break;
        case 2:
          System.out.println("Dia " + dia + " = Segunda");
          break;
        case 3:
          System.out.println("Dia " + dia + " = Terça");
          break;
        case 4:
          System.out.println("Dia " + dia + " = Quarta");
          break;
        case 5:
          System.out.println("Dia " + dia + " = Quinta");
          break;
        case 6:
          System.out.println("Dia " + dia + " = Sexta");
          break;
        case 7:
          System.out.println("Dia " + dia + " = Sábado");
          break;
        default: // caso não seja nenhum dos casos acima
          System.out.println("Entrada inválida! Digite um número de 1 a 7:");
          break;
        // break; // opcional, pois o default é o último caso
        // return; // opcional, pois o default é o último caso
        // System.exit(0); // opcional, pois o default é o último caso
        // throw new Exception("Dia inválido"); // opcional, pois o default é o último
      }
    } while (dia < 1 || dia > 7);
    scanner.close();
  }
}