package T16_TextProcesing_Exercise;

import java.util.Scanner;

public class E01_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(", ");

        for (String name : names) {
            if (isValidUsername(name)) {
                System.out.println(name);
            }
        }
    }

    private static boolean isValidUsername(String name) {

        if (name.length() < 3 || name.length() > 16) {
            return false;
        }
        for (int i = 0; i < name.length() ; i++) {
            char symbol = name.charAt(i);
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        return true;
    }
}
