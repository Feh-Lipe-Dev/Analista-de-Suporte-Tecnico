package jogo;

public class Personagem {
  private String nome;
  private String classe;
  private int nivel;

  public Personagem(String nome) {
    this.nome = nome;
    this.classe = "Nenhuma";
    this.nivel = 1;
  }

  public String toString() {
    String informacoes = String.format("Nome: %s - Classe: %s - Nível: %d.", nome, classe, nivel);
    return informacoes;
  }

  public void atacar() {
    System.out.format("%s atacou com socos.", nome);
    System.out.println("");
  }

  public void ataqueEspecial() {
    System.out.format("%s usou ataque especial \"mãos de pedra!\"", nome);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public int getNivel() {
    return nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }
}