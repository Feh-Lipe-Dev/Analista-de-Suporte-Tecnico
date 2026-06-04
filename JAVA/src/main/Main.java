
/**
 * comentário de documentação <b>javadoc</b>
 */

import java.util.List;
import java.util.ArrayList;

import pooJava.*;
import classes.*;
import listas.*;

public class Main {

  public static void main(String[] args) throws Exception {

    Pessoas pessoa1 = new Pessoas("João", 25);
    Empresa empresa1 = new Empresa("Fundição de Aço");
    //pessoa1.setEmpresa(empresa1);
    System.out.println(pessoa1.imprimir());
  }
}

/*
 * luno2.nome = "Maria";
 * aluno2.notas[0] = 6.5f;
 * aluno2.notas[1] = 5.7f;
 * 
 * aluno2.alunoNomeNotas();
 * aluno2.alunoMedia();
 * aluno2.verificaAprovacao();
 * 
 * // System.out.format("Aluno: %s\n Nota 1: %.1f\n Nota 2: %.1f", aluno.nome,
 * // aluno.notas[0], aluno.notas[1]);
 * }
 * }
 *
 * Personagem personagem1 = new Personagem("Felipe");
 * System.out.println(personagem1);
 * personagem1.atacar();
 * personagem1.ataqueEspecial();
 * System.out.println("\n");
 * Arqueiro arqueiro1 = new Arqueiro("Josué");
 * System.out.println(arqueiro1);
 * arqueiro1.atacar();
 * arqueiro1.ataqueEspecial(arqueiro1.getNome());
 * 
 * 
 * // Herança | Superclasse | Subclasse
 * 
 * Cachorro cachorro = new Cachorro("Rex");
 * cachorro.beber();
 * cachorro.pegarBolinha();
 * 
 * Gato gato = new Gato("Frajola");
 * gato.comer();
 * gato.pegarRato();
 * gato.petisco();
 * 
 * Series serie1 = new Series("Breaking Bad", 5, 2008);
 * Series serie2 = new Series("Game of Thrones", 8, 2011);
 * 
 * System.out.println(serie1);
 * System.out.println(serie2);
 * 
 * // comentário de uma linha
 * /*
 * comentário de múltiplas linhas
 */