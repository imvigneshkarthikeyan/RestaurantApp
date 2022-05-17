package Utilities;
import java.io.Console;
import java.util.Scanner;

public class ValidatorUtils {
    public static Scanner scanner = new Scanner(System.in);
    public static Console console = System.console();
    
    public static void optionValidator(int option, int a, int b) {
        if (option < a || option > b) {
            throw new IllegalArgumentException();
        }
    }
    
    public static String readPassword() {
        return console != null ? String.valueOf(console.readPassword()) : scanner.nextLine();
    }
}
