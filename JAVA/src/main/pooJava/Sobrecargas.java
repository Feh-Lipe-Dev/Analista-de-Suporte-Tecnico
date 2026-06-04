
//SOBRECARGA DE  MÉTODOS
// É a capacidade de criar métodos com o mesmo nome, mas com parâmetros diferentes.
// Isso permite que o método seja chamado de diferentes formas, dependendo dos argumentos passados.
// A sobrecarga de métodos é uma forma de polimorfismo.

package pooJava;

public class Sobrecargas {
  private String instrumento;
  private String tipo;
  private String marca;
  private String modelo;
  private String cor;

  public Sobrecargas() {

  }

  public void cadastroInstrumento(String instrumento, String tipo, String marca) {
    this.instrumento = instrumento;
    this.tipo = tipo;
    this.marca = marca;
    System.out.println("Instrumento: " + instrumento);
    System.out.println("Tipo: " + tipo);
    System.out.println("Marca: " + marca);
    System.out.println("Cadastro realizado com sucesso!");
    System.out.println("----------------------------------------------");
  }

  public void cadastroInstrumento(String instrumento, String tipo, String marca, String modelo) {
    this.instrumento = instrumento;
    this.tipo = tipo;
    this.marca = marca;
    this.modelo = modelo;
    System.out.println("Instrumento: " + instrumento);
    System.out.println("Tipo: " + tipo);
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Cadastro realizado com sucesso!");
    System.out.println("----------------------------------------------");
  }

  public void cadastroInstrumento(String instrumento, String tipo, String marca, String modelo, String cor) {
    this.instrumento = instrumento;
    this.tipo = tipo;
    this.marca = marca;
    this.modelo = modelo;
    this.cor = cor;
    System.out.println("Instrumento: " + instrumento);
    System.out.println("Tipo: " + tipo);
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Cor: " + cor);
    System.out.println("Cadastro realizado com sucesso!");
    System.out.println("----------------------------------------------");
  }

  // Exemplos:
  /*
  sobrecargas.cadastroInstrumento(instrumento, tipo, marca);
  sobrecargas.cadastroInstrumento("Guitarra", "Cordas", "Fender");
  
  sobrecargas.cadastroInstrumento(instrumento, tipo, marca, modelo);
  sobrecargas.cadastroInstrumento("Guitarra", "Cordas", "Fender", "Telecaster");
  
  sobrecargas.cadastroInstrumento(instrumento, tipo, marca, modelo, cor);
  sobrecargas.cadastroInstrumento("Guitarra", "Cordas", "Fender", "Telecaster", "Preto");
  */
}
