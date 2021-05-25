package T00_MoreExercise;

import java.util.Scanner;

public class M01_DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            char element = input.charAt(0);
            if (input.contains("-")) {
                System.out.println(String.format("%s is integer type", input));
            }
            if (Character.isDigit(element)) {
                if (input.contains(".")) {
                    System.out.println(String.format("%s is floating point type", input));
                } else {
                    System.out.println(String.format("%s is integer type", input));
                }
            }
            if (input.charAt(0) == 't' || input.charAt(0) == 'f') {
                System.out.println(String.format("%s is boolean type", input));

            } else if (Character.isLetter(element) && input.length() <= 1) {
                System.out.println(String.format("%s is character type", input));
            }
            if (Character.isLetter(element) && input.length() > 1){
                if (!input.contains("true") && !input.contains("false")) {
                    System.out.println(String.format("%s is string type", input));
                }

            }
            input = scanner.nextLine();
        }
    }
}
