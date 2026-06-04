
package classes;

public class Series {
  private String nome;
  private int temporada;
  private int ano;

  public Series(String nome, int temporada, int ano) {
    this.nome = nome;
    this.temporada = temporada;
    this.ano = ano;
  }

  /*
   * public String pegarInformacoes() {
   * String informacoes = String.format("Nome: %s (%d) - Temporadas: %d.\n", nome,
   * ano, temporada);
   * return informacoes;
   * }
   */

  // sobrecarga de método: mesmo nome, mas parâmetros diferentes
  // @Override - sobreescrever o método toString() da classe Object
  @Override
  public String toString() {
    String informacoes = String.format("Nome: %s (%d) - Temporadas: %d.\n", nome, ano, temporada);
    return informacoes;
  }

  public String getNome() {
    return nome;
  }

  public int getTemporada() {
    return temporada;
  }

  public int getAno() {
    return ano;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setTemporada(int temporada) {
    this.temporada = temporada;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

}
