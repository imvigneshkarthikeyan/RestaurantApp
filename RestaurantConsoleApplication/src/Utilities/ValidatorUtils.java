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
    public static int readInt() {
        int val = -1;
        try {
            val = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input! Please enter a positive number!");
            return val;
        }
        return val < 0 ? -1 : val;
    }
    public static double readDouble() {
        double val = -1;
        try {
            val = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input! Enter a positive number!");
            return val;
        }
        return val;
    }
    public static String readPassword() {
        return console != null ? String.valueOf(console.readPassword()) : scanner.nextLine();
    }
}
