//ENTRADA DE DADOS | SCANNER
//Scanner é uma classe que permite a leitura de dados do teclado.
//é necessário importar a classe Scanner. (import java.util.Scanner;)
//é necessário criar um objeto Scanner. (Scanner scanner = new Scanner(System.in);)

/*
No Visual Studio Code, é necessário instalar a extensão "Java Extension Pack"
para que o Scanner funcione e seja possível digitar os dados no console.
Nas configurações de debug de console dessa extensão, é necessário escolher a opção "integratedTerminal"
*/

import java.util.Scanner;

public class EntradaDados {
  public static void main(String[] args) {

    String nome;
    int idade;
    double altura;
    double peso;
    char sexo;
    String estadoCivil;

    // Cria um objeto Scanner para ler a entrada do teclado
    // System.in é a entrada padrão do sistema, que é o teclado
    // scanner é declarado apenas uma vez, e pode ser usado várias vezes, para ler
    // diferentes tipos de dados
    Scanner scanner = new Scanner(System.in);

    // nextLine() lê uma linha inteira de texto até o enter ser pressionado.
    System.out.println("Digite seu nome: ");
    nome = scanner.nextLine();

    // nextInt() lê um número inteiro
    System.out.println("Digite sua idade: ");
    idade = scanner.nextInt();

    // nextDouble() lê um número decimal
    System.out.println("Digite sua altura: ");
    altura = scanner.nextDouble();
    System.out.println("Digite seu peso: ");
    peso = scanner.nextDouble();

    // next().charAt(0) lê um caractere
    System.out.println("Digite seu sexo: ");
    sexo = scanner.next().charAt(0);

    // next() lê uma palavra até o espaço ser pressionado. Não é possível ler uma
    // frase com espaço.
    System.out.println("Digite seu estado civil: ");
    estadoCivil = scanner.next();

    // Fecha o objeto Scanner
    scanner.close();

    System.out.println("\nCadastro realizado com sucesso!");
    String cadastro = String.format("Nome: %s\nIdade: %d\nAltura: %.2f\nPeso: %.2f\nSexo: %c\nEstado Civil: %s", nome,
        idade, altura, peso, sexo, estadoCivil);

  }
}