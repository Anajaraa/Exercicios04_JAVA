//Desenvolva um método que realiza operações matemáticas básicas (adição, subtração, multiplicação e divisão) com base em dois números fornecidos pelo usuário e uma operação especificada. Se a operação não for reconhecida, deve ser lançada uma exceção personalizada `InvalidOperationException`. Se uma divisão por zero for tentada, deve ser lançada uma exceção `ArithmeticException`.

import java.util.Scanner;

class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }
}

public class Caso5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Digite o primeiro número: ");
            double numero1 = sc.nextDouble();

            System.out.print("Digite o segundo número: ");
            double numero2 = sc.nextDouble();

            System.out.print("Digite a operação (+, -, *, /): ");
            String operacao = sc.next();

            double resultado = realizarOperacao(numero1, numero2, operacao);
            System.out.println("Resultado: " + resultado);

        } catch (InvalidOperationException | ArithmeticException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static double realizarOperacao(double num1, double num2, String operacao) throws InvalidOperationException, ArithmeticException {
        switch (operacao) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Erro: Divisão por zero não permitida.");
                }
                return num1 / num2;
            default:
                throw new InvalidOperationException("Operação inválida: " + operacao);
        }
    }
}
