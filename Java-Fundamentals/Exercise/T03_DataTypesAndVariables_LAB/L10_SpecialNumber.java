package T03_DataTypesAndVariables_LAB;

import java.util.Scanner;

public class L10_SpecialNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number ; i++) {

            int sumOfDigits = 0;
            int digits = i;
            while (digits > 0) {
                sumOfDigits += digits % 10;
                digits = digits / 10;
            }
            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                System.out.println(String.format("%d -> True",i));
            } else {
                System.out.println(String.format("%d -> False",i));
            }
        }

    }
}
