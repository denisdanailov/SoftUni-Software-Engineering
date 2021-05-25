package T15_TextProcesing_LAB;

import java.util.List;
import java.util.Scanner;

public class L05_DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder alphabetic = new StringBuilder();
        StringBuilder chars = new StringBuilder();



        for (int i = 0; i <input.length() ; i++) {
            char current = input.charAt(i);
            if (Character.isDigit(current)) {
                digits.append(current);
            } else if (Character.isAlphabetic(current)) {
                alphabetic.append(current);
            } else {
                chars.append(current);
            }
        }
        System.out.println(digits);
        System.out.println(alphabetic);
        System.out.println(chars);
    }
}
