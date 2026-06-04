
// ARRAYSLIST - ARRAYS DINÂMICOS

// São arrays que podem crescer e diminuir de tamanho dinamicamente.
// Podem ser usados para armazenar qualquer tipo de dado.
// São mais lentos que os arrays normais, pois precisam de mais memória.
// Porém são mais flexíveis e fáceis de usar. 
// SINTAXE: ArrayList<tipo> nome = new ArrayList<tipo>();
// importar o pacote Arraylist: import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

import jogo.Personagem;

public class ArrayListLessons {
  public static void main(String[] args) {

    ArrayList<String> carros = new ArrayList<String>();

    // add() - adiciona um elemento ao final da lista)
    carros.add("Fusca");
    carros.add("Brasília");
    carros.add("Chevette");

    // imprimindo a lista com forEach
    System.out.println(carros);
    System.out.println("\nPercorrendo a lista com forEach: ");
    for (String carro : carros) {
      System.out.println("Carro: " + carro);
    }

    // imprimindo a lista com for
    System.out.println("\nPercorrendo a lista com for: ");
    // size() - retorna o tamanho da lista
    // variável length só para arrays normais (não dinâmicos)
    System.out.println("Tamanho da lista: " + carros.size());
    for (int i = 0; i < carros.size(); i++) {
      System.out.println("Indice " + i + ", valor: " + carros.get(i));
      // get() - retorna o elemento do índice especificado
      // [] com o valor do índice só para arrays normais (não dinâmicos)
    }

    // remove() - remove o elemento do índice especificado
    carros.remove(1);
    System.out.println("\nLista após remover o elemento do índice 1: ");
    for (String carro : carros) {
      System.out.println(carro);
    }

    // clear() - remove todos os elementos da lista
    carros.clear();
    System.out.println("\nLista após remover todos os elementos: ");
    System.out.println(carros);
    System.out.println("Tamanho " + carros.size());

    // isEmpty() - verifica se a lista está vazia
    System.out.println("\nLista está vazia? " + carros.isEmpty());

    carros.add("Fusca");
    carros.add("Kombi");

    // contains() - verifica se a lista contém o elemento especificado
    System.out.println("\nLista contém o elemento 'Fusca'? " + carros.contains("Fusca"));

    // indexOf() - retorna o índice do elemento especificado
    System.out.println("\nÍndice do elemento 'Fusca': " + carros.indexOf("Fusca"));

    // set() - altera o elemento do índice especificado
    carros.set(0, "Opala");
    System.out.println("\nLista após alterar o elemento do índice 0: ");
    System.out.println(carros);

    // TRABALHANDO COM TIPOS PRIMITIVOS
    // Para tipos primitivos, é necessário usar a classe wrapper
    // Exemplo: int -> Integer, double -> Double, char -> Character, boolean ->
    // Boolean

    ArrayList<Integer> numeros01 = new ArrayList<Integer>();
    numeros01.add(1);
    numeros01.add(2);
    numeros01.add(3);
    System.out.println("\nLista de números: " + numeros01);
    ArrayList<Integer> numeros02 = new ArrayList<Integer>();
    numeros02.add(4);
    numeros02.add(5);
    numeros02.add(6);
    System.out.println("Lista de números: " + numeros02);
    // addAll() - adiciona todos os elementos de uma lista a outra
    ArrayList<Integer> numeros03 = new ArrayList<Integer>();
    numeros03.addAll(numeros02);
    numeros03.addAll(numeros01);
    System.out.println("Listas 01 e 02 adicionadas a 03: " + numeros03);

    // sort() - ordena a lista em ordem crescente
    numeros03.sort(null);
    System.out.println("Lista 03 ordenada: " + numeros03);
    // sort() com reverseOrder() - ordena a lista em ordem decrescente
    numeros03.sort(Collections.reverseOrder());
    System.out.println("Lista 03 ordenada em ordem decrescente: " + numeros03);

    // ARRAYLIST DE OBJETOS
    // Para criar um ArrayList de objetos, é necessário criar uma classe que
    // represente o objeto e instanciar essa classe para criar os objetos.
    // Exemplo: Personagem personagem1 = new Personagem("Felipe");

    Personagem personagem1 = new Personagem("Felipe");
    Personagem personagem2 = new Personagem("Maria");
    Personagem personagem3 = new Personagem("João");
    ArrayList<Personagem> personagens = new ArrayList<Personagem>();
    personagens.add(personagem1);
    personagens.add(personagem2);
    personagens.add(personagem3);
    // também é possível adicionar objetos diretamente na lista
    personagens.add(new Personagem("José"));
    personagem2.setNivel(2);
    personagem3.setClasse("Arqueiro");
    System.out.println("\nLista de personagens: " + personagens);
    for (Personagem personagem : personagens){
      System.out.println(personagem);
      if (personagem.getNome() == "Maria") personagem.atacar();
    }
  }
}