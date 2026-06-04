//STATIC - MODIFICADOR DE ACESSO, VARIÁVEIS, MÉTODOS E BLOCOS DE INICIALIZAÇÃO

// MODIFCADOR STATIC
// É um modificador que pode ser aplicado a variáveis, constantes, métodos e blocos de inicialização.
// Quando aplicado a uma variável, ela se torna uma variável de classe, ou seja, ela é compartilhada por todas as instâncias da classe.
// Quando aplicado a um método, ele se torna um método de classe, ou seja, ele pode ser chamado sem a necessidade de criar uma instância da classe.
// Quando aplicado a um bloco de inicialização, ele se torna um bloco de inicialização de classe, ou seja, ele é executado quando a classe é carregada na JVM.

package pooJava;

public class ModStatic {
  // Exemplo de variável static com uma classe para representar um carro
  private String nome;
  private double velocidadeMaxima;
  public static double velocidadeLimite = 250;

  static {
    System.out.println("Velocidade Limite: " + ModStatic.velocidadeLimite);
  }
  {
    System.out.println("Bloco de inicialização 1 (não estático)");
  }

  // como a variável velocidadeLimite é static, pode ser acessada diretamente pela
  // classe, sem a necessidade de criar uma instância da classe.
  // ModStatic.velocidadeLimite = 260; funciona no main desde que seja do tipo
  // public, porém não é recomendado.

  public ModStatic(String nome, double velocidadeMaxima) {
    this.nome = nome;
    this.velocidadeMaxima = velocidadeMaxima;
  }

  public void imprimirCarro() {
    System.out.println("------------------------------------");
    System.out.println("Nome: " + this.nome);
    System.out.println("Velocidade Máxima: " + this.velocidadeMaxima);
    // System.out.println("Velocidade Limite: " + ModStatic.velocidadeLimite);
  }

  /*
   * 
   * EXEMPLO:
   * ModStatic carro1 = new ModStatic("BMW", 280);
   * SAÍDAS = Nome: BMW; Velocidade máxima: 280; Velocidade Limite: 250.0
   * Velocidade Limite é a mesma para todos os objetos da classe ModStatic, pois é
   * uma variável static.
   * 
   */

  public void imprimirVelocidadeLimite() {
    System.out.println("------------------------------------");
    System.out.println(this.nome + " - Velocidade Limite: " + ModStatic.velocidadeLimite);
  }

  // Uma variável static pode ser acessada diretamente pela classe, sem a
  // necessidade de criar uma instância da classe.
  public double getVelocidadeLimite() {
    return ModStatic.velocidadeLimite;
  }

  public void setVelocidadeLimite(double velocidadeLimite) {
    ModStatic.velocidadeLimite = velocidadeLimite;
  }

  // MÉTODOS STATIC
  // São métodos que podem ser chamados sem a necessidade de criar uma instância
  // da classe.
  // São métodos que não podem acessar variáveis de instância, pois não há
  // instância da classe.

  // EXEMPLO:
  public static void imprimirVelocidadeLimiteStatic() {
    System.out.println("Velocidade Limite: " + ModStatic.velocidadeLimite);
    // System.out.println(this.velocidadeMaxima); // não funciona, pois não há
    // instância da classe.
  }
  // para chamar o método static, basta chamar pela classe:
  // ModStatic.imprimirVelocidadeLimiteStatic();
  // não é necessário criar uma instância da classe.s

  // BLOCOS DE INICIALIZAÇÃO STATIC
  // São blocos de inicialização que são executados quando a classe é carregada na
  // JVM.
  // São blocos de inicialização que não podem acessar variáveis de instância,
  // pois não há instância da classe.
  static {
    System.out.println("Bloco de inicialização static 1");
  }
  // pode ser criado mais de um bloco de inicialização static, e eles serão
  // executados na ordem em que são declarados.
  static {
    System.out.println("Bloco de inicialização static 2");
  }
}