/**
 * comentário de documentação <b>javadoc</b>
 */

// VARIÁVEIS NO JAVA
// variáveis são espaços na memória do computador que armazenam dados. São
// identificadas pelo seu tipo seguido do seu nome.
// tipos primitivos: int, double, float, boolean, char, long, byte, short
// tipos não primitivos: String, Array, Class, Interface, Enum

/*
 * - REGRAS PARA NOMEAR VARIÁVEIS
 * 1. não pode começar com número
 * 2. não pode conter espaços
 * 3. não pode conter caracteres especiais
 * 4. não pode conter acentos
 * 5. não pode conter palavras reservadas da linguagem (por exemplo, int,
 * double, float, boolean, char, String, long, byte, short)
 * 6. pode conter underline (_) e cifrão ($)
 * 7. pode conter letras maiúsculas e minúsculas
 * 8. pode conter números, mas não no início
 * 9. para nomes compostos, usar camelCase (por exemplo, nomeCompleto,
 * idadeDoAluno)
 * 10. Java é case sensitive (diferencia maiúsculas de minúsculas)
 */

public class TiposPrimitivos {
    public static void main(String[] args) {

        // tipos para inteiros: int, byte, short, long
        System.out.println("");
        int inteiro = 10;
        System.out.println("Palavra reservada int para inteiros. Exemplo: int inteiro =" + inteiro + "\n");
        byte byte_ = 127;
        System.out.println("Palavra reservada byte para inteiros curtos. Exemplo: byte byte_ = " + byte_ + "\n");
        short short_ = 32767;
        System.out.println("Palavra reservada short para inteiros curtos. Exemplo: short short_ = " + short_ + "\n");
        long longo = 1000000000000000000L;
        System.out.println("Palavra reservada long para inteiros longos. Exemplo: long longo = " + longo
                + ". É necessário colocar um L no final do número.\n");

        // tipos para decimais: double, float
        double decimal_double = 10.5;
        System.out
                .println("Palavra reservada double para decimais. Exemplo: double decimal_double = " + decimal_double
                        + "\n");
        float decimal_float = 10.5f;
        System.out.println(
                "Palavra reservada float para decimais. Exemplo: float decimal_float = " + decimal_float
                        + ". É necessário colocar um f no final do número.\n");
        System.out
                .println("***float é um tipo primitivo que ocupa 32 bits na memória, enquanto double ocupa 64 bits.\n");

        // tipo booleano: boolean. Aceita apenas true ou false
        boolean booleano = true;
        System.out.println("Palavra reservada boolean para booleanos. Exemplo: boolean booleano = " + booleano
                + ". Sempre será true ou false.\n");

        // tipo caractere: char. Aceita apenas um caractere. Usar aspas simples
        char caracter = 'a';
        System.out.println("Palavra reservada char para caracteres. Exemplo: char caracter = " + caracter + "\n");

        // Variável do tipo String
        // String não é um tipo primitivo, mas sim uma classe que representa uma
        // sequência de caracteres.
        // S maiúsculo para declarar (classe) e aspas duplas para atribuir valor.
        String texto = "Olá, mundo!";
        System.out.println("Palavra reservada String para textos. Exemplo: String texto = " + texto);
        System.out.println("***String é uma classe que representa uma sequência de caracteres.\n");
    }
    // comentário de uma linha
    /*
     * comentário de múltiplas linhas
     */
}