package animais;

public class Animais {
  private String nome;

  public Animais(String nome) {
    this.nome = nome;
    // *this.nome refere-se ao atributo da classe: private String nome;
    // *nome refere-se ao parâmetro do método construtor: public Animais(String nome)
  }

  public void comer() {
    System.out.printf("%s está comendo.\n", nome);
  }

  public void beber() {
    System.out.printf("%s está bebendo água.\n", nome);
  }

  public void petisco() {
    System.out.printf("Quer um petisco, %s?\n", nome);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}