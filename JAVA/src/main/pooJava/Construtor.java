package pooJava;

// CONSTRUTOR
// É um método especial que é chamado quando um objeto é criado.
// Ele tem o mesmo nome da classe e não tem retorno (nem mesmo void).
// Pode ser usado para inicializar os atributos do objeto.
// Pode ser sobrecarregado, ou seja, ter mais de um construtor na mesma classe.
// Se não for definido nenhum construtor, o Java cria um construtor padrão.
// O construtor padrão não recebe parâmetros e não faz nada.
// O construtor padrão é chamado quando um objeto é criado sem parâmetros.
// Se for definido um construtor, o construtor padrão não é criado.
// Se for definido um construtor com parâmetros, o construtor padrão não é criado.

public class Construtor {
  String tipoPC;
  String marca;
  String modelo;
  int memoriaRAM;
  int armazenamento;
  int anoFabricacao;

  public Construtor() {
    // System.out.println("Construtor padrão, sem parâmetros.");
    // System.out.println("Se o construtor padrão não for definido, o Java cria um
    // construtor padrão.");
    // System.out.println("------------------------------------------------------------------------------------------");
  }

  public Construtor(String tipoPC, String marca, String modelo, int memoriaRAM, int armazenamento) {
    this();
    this.tipoPC = tipoPC;
    this.marca = marca;
    this.modelo = modelo;
    this.memoriaRAM = memoriaRAM;
    this.armazenamento = armazenamento;
    // System.out.println("Construtor com parâmetros.");
    // System.out
    // .println("Se o construtor padrão já foi feito, o construtor com parâmetros
    // funcionará como uma sobrecarga.");
  }

  public Construtor(String tipoPC, String marca, String modelo, int memoriaRAM, int armazenamento, int anoFabricacao) {
    // this(parametros) precisa ser a primeira linha do construtor
    this(tipoPC, marca, modelo, memoriaRAM, armazenamento);
    this.anoFabricacao = anoFabricacao;
  }

  public void imprimirConstrutor() {
    System.out.println("\nTipo de PC: " + tipoPC);
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Memória RAM: " + memoriaRAM);
    System.out.println("Armazenamento: " + armazenamento);
    if (anoFabricacao == 0) {
      System.out.println("Ano de Fabricação: não informado");
    } else {
      System.out.println("Ano de Fabricação: " + anoFabricacao);
    }
    System.out.println("------------------------------------");
  }
}
