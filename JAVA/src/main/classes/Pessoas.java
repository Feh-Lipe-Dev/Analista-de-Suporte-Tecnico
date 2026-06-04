package classes;

import listas.*;

public class Pessoas {
  private String nome;
  private int idade;
  private Empresa empresa;

  public Pessoas() {
  }

  public Pessoas(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  @Override
  public String toString() {
    return "Nome: " + nome + ", idade: " + idade + ", empresa: "
        + (empresa != null ? empresa.getNome() : "Sem empresa");
  }
}
