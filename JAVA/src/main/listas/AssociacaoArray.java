package listas;

import classes.Pessoas;

//Associação de Arrays
//Associação de Arrays é uma técnica que permite criar um array de objetos de uma classe específica.
//Isso é útil quando você precisa armazenar e manipular uma coleção de objetos de uma classe específica.

public class AssociacaoArray {

  public static void main(String[] args) {

    // Criando objetos da classe Pessoa
    // Pessoas pessoa2 = new Pessoas("Maria", 30);
    // Pessoas pessoa1 = new Pessoas("João", 25);
    // Pessoas pessoa3 = new Pessoas("José", 20);

    // Criando um array de objetos da classe Pessoa
    // O array é criado com o tipo da classe (nesse caso, Pessoa) e o nome do array
    // Pessoas[] pessoas = { pessoa1, pessoa2, pessoa3 };
    // int cout = 1;

    // Imprimindo os objetos do array
    // System.out.println("Lista de pessoas: ");
    // for (Pessoas pessoa : pessoas) {
    // System.out.println(cout + " - " + pessoa);
    // cout++;

    Pessoas pessoa1 = new Pessoas("João", 25);
    Empresa empresa1 = new Empresa("Fundição de Aço");
    pessoa1.setEmpresa(empresa1);
    System.out.println(pessoa1.getEmpresa());
  }
}