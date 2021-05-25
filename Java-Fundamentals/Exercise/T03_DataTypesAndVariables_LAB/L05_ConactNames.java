package T03_DataTypesAndVariables_LAB;

import java.util.Scanner;

public class L05_ConactNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String symbol = scanner.nextLine();


        System.out.printf("%s%s%s",firstName,symbol,lastName);

    }
}
