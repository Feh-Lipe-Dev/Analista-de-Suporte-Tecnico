//IMPRESSÕES NO CONSOLE | PRINT | PRINTLN | PRINTF
//System.out.print(); //imprime sem quebra de linha
//System.out.println(); //imprime com quebra de linha
//System.out.printf(); //imprime formatado

//FORMAT
//o método format() é usado para formatar a saída de dados.
//é um método da classe String.
//é possível usar especificadores de formato para formatar a saída de dados.
//os especificadores de formato são colocados dentro de chaves {}.
//os especificadores de formato são: %d, %f, %s, %c, %b, %e, %g, %h, %n, %o, %x, %X, %t, %T,
//FORMATOS MAIS USADOS:
//%d - inteiro; %f - float
//%s - string; %c - char
//%b - boolean; %n - quebra de linha
//%t - data; %T - hora
//%e - notação científica; %g - notação científica ou decimal
//double - 

public class Prints {
  public static void main(String[] args) {
    System.out.print("Olá, mundo! "); // imprime sem quebra de linha
    System.out.println("Olá, mundo!"); // imprime com quebra de linha
    System.out.printf("Valor de PI: %f%n", 3.14159); // imprime formatado
    System.out.printf("Valor de PI: %.2f%n", 3.14159); // imprime formatado

    String celular = "Samsung S";
    double preco = 1500.00;
    String comprar = String.format("O aparelho é um %s, está custando R$ %g.", celular, preco);
    System.out.println(comprar);
  }
}