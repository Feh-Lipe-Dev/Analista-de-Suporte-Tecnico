package jogo;

public class Arqueiro extends Personagem {
  String arma = "Arco Pequeno";

  public Arqueiro(String nome) {
    super(nome);
    setClasse("Arqueiro");
    setNivel(2);
  }

  @Override
  public String toString() {
    String infosPersonagem = super.toString();
    String infosArqueiro = String.format(" Arma: %s.", arma);
    return infosPersonagem + infosArqueiro;
  }

  @Override
  public void atacar() {
    System.out.format("%s atacou com %s.\n", getNome(), arma);
  }

  public void ataqueEspecial(String personagem) {
    System.out.format("%s usou ataque especial \"flecha explosiva!\"", personagem);
  }
}