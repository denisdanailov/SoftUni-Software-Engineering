package T08_MEthods_Exercise;

import java.util.Scanner;

public class E09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String number = input;

            if (number.length() == 1) {
                System.out.println("true");
            }

            if (input.length() == 4) {
                 if (number.charAt(0) == number.charAt(3) && number.charAt(1) == number.charAt(2)) {
                    System.out.println("true");
                } else {
                     System.out.println("false");
                 }
            }
            if (input.length() == 3 ) {
                if (number.charAt(0) == number.charAt(2) ) {
                    System.out.println("true");
                }  else {
                    System.out.println("false");
                }
            }
            if (number.length() == 2) {
                if (number.charAt(0) == number.charAt(1)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }

            }

           input = scanner.nextLine();
        }

    }
}
