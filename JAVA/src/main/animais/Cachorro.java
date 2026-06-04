package animais;

//Cachorro (subclasse) herda de Animais (superclasse)

public class Cachorro extends Animais {

  public Cachorro(String nome) {
    super(nome);
  }

  public void latir() {
    System.out.printf("%s está latindo.\n", getNome());
  }

  public void pegarBolinha() {
    System.out.printf("%s, pega a bolinha!\n", getNome());
  }
}