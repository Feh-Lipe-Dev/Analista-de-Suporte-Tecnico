package pooJava;

// BLOCO DE INICIALIZAÇÃO (INICIALIZADOR DE INSTÂNCIA)
// É um bloco de código que é executado quando um objeto é criado.
// Pode ser usado para inicializar os atributos do objeto.
// Pode ser usado para executar qualquer código que precise ser executado quando um objeto é criado.
// Pode ser usado para executar código antes do construtor ser chamado.
// sintaxe: { código } - um bloco de código entre chaves sem nenhum nome ou parâmetros.

public class BlocoDeInicia {
  private String nome;
  private int[] episodios;

  // sintaxe: { código } - um bloco de código entre chaves sem nenhum nome ou parâmetros.
  {
    System.out.println("Bloco de inicialização de instância");
    episodios = new int[6];
    for (int i = 0; i < episodios.length; i++) {
      episodios[i] = i + 1;
    }
  }

  public BlocoDeInicia() {
    System.out.println("\nConstrutor de instância sem parâmetros\n");
  }

  public BlocoDeInicia(String nome) {
    this.nome = nome;
    System.out.println("Construtor de instância");
    System.out.println("Nome: " + nome);
    System.out.print("Episódios: ");
    for (int episodio : this.episodios) {
      System.out.print(episodio + " ");
    }
  }
}