import java.util.Scanner;

public class Console {

    private static Scanner leitor = new Scanner(System.in);

    public static int lerInt() {
        int valor = leitor.nextInt();
        limparBuffer();
        return valor;
    }

    public static String lerString() {
        return leitor.nextLine();
    }
    
    private static void limparBuffer() {
        if (leitor.hasNextLine()) {
            leitor.nextLine();
        }
    }
}
