import java.util.Scanner;

public class Taxas {
  public static void main(String[] args) {

    /*
     * 35.82% até €38,441 ano
     * 37.48% entre €38,441 e €76,817 ano.
     * 49.50% acima de €76,817 ano.
     * For people receiving the state pension (AOW), a lower combined rate applies
     * to the first bracket.
     */

    double income = 0.0;
    String pensioner = "";
    int pensionerInt;
    double tax01 = 35.82 / 100;
    double tax02 = 37.48 / 100;
    double tax03 = 49.5 / 100;
    double taxToPay = 0.0;
    int taxCode = 1;
    int count = 2;
    Scanner input = new Scanner(System.in);

    System.out.print("É aposentado (0 = não / 1 = sim): ");
    pensionerInt = input.nextInt();

    while (pensionerInt != 0 && pensionerInt != 1 && count > 0) {
      System.out.print(" \n");
      System.out.printf("%d é uma opção inválida. Você tem mais %d tentativas\n", pensionerInt, count);
      System.out.print("É aposentado (não = 0 / sim = 1): ");
      pensionerInt = input.nextInt();
      count--;
      if (pensionerInt != 0 && pensionerInt != 1 && count < 1) {
        System.out.println("Número de tentativas excedido. Encerrando o programa.");
        System.exit(0);
      }
    }

    System.out.println("Informe sua renda anual: ");
    income = input.nextDouble();
    input.close();

    if (pensionerInt == 1) {
      pensioner = "Sim";
      taxToPay = income * tax01;
    } else if (income <= 38441) {
      pensioner = "Não";
      taxToPay = income * tax02;
    } else if (income > 38441 && income <= 76817) {
      pensioner = "Não";
      taxToPay = income * tax02;
      taxCode = 2;
    } else {
      pensioner = "Não";
      taxToPay = income * tax03;
      taxCode = 3;
    }
    System.out.println("É aposentado: " + pensioner);
    System.out.printf("Renda anual: %.2f%n", income);
    System.out.println("Sua renda é taxa " + taxCode);
    System.out.format("valor a pagar: %.2f", taxToPay);
    // TESTES
    // taxa 1: até 38.441,00 - ok
    // taxa 2: de 38.441,01 até 76.817,00 - ok
    // taxa 3: acima de 76.817,00 - ok
    // aposentado - ok

  }
}