package classes;

public class CadAluno {
  public String nome;
  public float notas[] = new float[3];

  void alunoNomeNotas() {
    System.out.println("Nome do aluno: " + nome);
    int i = 0;
    for (i = 0; i < notas.length; i++) {
      System.out.println("Nota " + (i + 1) + ": " + notas[i]);
    }
    System.out.format("Média: %.1f\n", alunoMedia());
  }

  float alunoMedia() {
    float soma = 0;
    for (int i = 0; i < notas.length; i++) {
      soma += notas[i];
    }
    float media = soma / notas.length;
    return media;
  }

  void verificaAprovacao() {
    String aprovado = "Aprovado";
    if (alunoMedia() < 7) {
      aprovado = "Reprovado";
    }
    System.out.println("Situação: " + aprovado);
  }
}
