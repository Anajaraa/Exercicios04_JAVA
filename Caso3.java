//Desenvolva um método que recebe uma lista de strings e tenta convertê-las para inteiros. Se a conversão de uma string para inteiro falhar, deve ser lançada uma exceção personalizada `InvalidTypeConversionException` e o programa deve continuar tentando converter as outras strings da lista.



import java.util.ArrayList;
import java.util.List;

class InvalidTypeConversionException extends Exception {
    public InvalidTypeConversionException(String message) {
        super(message);
    }
}

    public class Caso3 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("100");
        strings.add("60a");
        strings.add("530");
        strings.add("ana");
        strings.add("240");

        List<Integer> inteiros = converterStringsParaInteiros(strings);

        System.out.println("Números convertidos: " + inteiros);
    }

    public static List<Integer> converterStringsParaInteiros(List<String> strings) {
        List<Integer> inteiros = new ArrayList<>();

        for (String str : strings) {
            try {
                int numero = Integer.parseInt(str);
                inteiros.add(numero);
            } catch (NumberFormatException e) {
                try {
                    throw new InvalidTypeConversionException("Falha ao converter '" + str + "' para inteiro.");
                } catch (InvalidTypeConversionException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

        return inteiros;
    }
}
