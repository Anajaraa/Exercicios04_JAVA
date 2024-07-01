//Implemente um método que remove um elemento de uma lista de strings com base em um índice fornecido pelo usuário. Se o índice estiver fora dos limites da lista, deve ser lançada uma exceção personalizada `IndexOutOfBoundsException`. O programa deve pedir ao usuário para tentar novamente com um índice válido.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidIndexException extends Exception {
    public InvalidIndexException(String message) {
        super(message);
    }
}

public class Caso4 {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Neto");
        nomes.add("Doug");
        nomes.add("Dennys");
        nomes.add("Pedro");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Lista atual: " + nomes);
            System.out.print("Digite o índice do nome a ser removido (0 a " + (nomes.size() - 1) + "): ");
            int indice = sc.nextInt();

            try {
                removerElementoPorIndice(nomes, indice);
                System.out.println("Nome removido com sucesso!");
                break;
            } catch (InvalidIndexException e) {
                System.err.println(e.getMessage());
                System.out.println("Tente novamente com um índice válido.");
            }
        }

        System.out.println("Lista final: " + nomes);
        sc.close();
    }

    public static void removerElementoPorIndice(List<String> lista, int indice) throws InvalidIndexException {
        if (indice < 0 || indice >= lista.size()) {
            throw new InvalidIndexException("Índice fora dos limites: " + indice);
        }
        lista.remove(indice);
    }
}
