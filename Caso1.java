import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ArquivoNaoEncontradoException extends Exception {
    public ArquivoNaoEncontradoException(String message) {
        super(message);
    }
}

class FormatoNumeroInvalidoException extends Exception {
    public FormatoNumeroInvalidoException(String message) {
        super(message);
    }
}

class InvalidNumberFormatException extends Exception {
    public InvalidNumberFormatException(String message) {
        super(message);
    }
}

public class Caso1 {

    public static void main(String[] args) {
        String numeros = "numeros.txt";
        try {
            int soma = calcularSomaDoArquivo(numeros);
            System.out.println("Soma dos números no arquivo: " + soma);
        } catch (ArquivoNaoEncontradoException | FormatoNumeroInvalidoException | InvalidNumberFormatException | FileNotFoundException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static int calcularSomaDoArquivo(String numeros) throws FileNotFoundException, ArquivoNaoEncontradoException, FormatoNumeroInvalidoException, InvalidNumberFormatException {
        int soma = 0;
        Scanner sc = null;
        try {
            sc = new Scanner(new File(numeros));
            while (sc.hasNext()) {
                String numeroString = sc.next().trim();
                try {
                    int numero = Integer.parseInt(numeroString);
                    soma += numero;
                } catch (NumberFormatException e) {
                    throw new InvalidNumberFormatException("Número inválido encontrado: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new ArquivoNaoEncontradoException("Arquivo não encontrado: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return soma;
    }
}

