package animais;

public class Gato extends Animais {

  public Gato(String nome) {
    super(nome);
  }

  public void miar() {
    System.out.printf("%s está miando.\n", getNome());
  }

  public void pegarRato() {
    System.out.printf("Pega o rato %s!\n", getNome());
  }
}