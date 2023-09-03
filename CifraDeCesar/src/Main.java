import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe o texto a ser descriptografado: ");
        String texto = entrada.nextLine();
        int tamanhoTexto = texto.length();

        System.out.println("\n\nTEXTO CRIPTOGRAFADO: " + texto);
        for (int cha = 0; cha < 26; cha++) {
            StringBuilder textoDecifrado = new StringBuilder();
            for (int c = 0; c < tamanhoTexto; c++) {
                int letraDescifradaASCII = ((int) texto.charAt(c) - cha);
                textoDecifrado.append((char) letraDescifradaASCII);
                System.out.println("\n\nTEXTO DESCRIPTOGRAFADO: " + textoDecifrado);
            }
        }
    }

}