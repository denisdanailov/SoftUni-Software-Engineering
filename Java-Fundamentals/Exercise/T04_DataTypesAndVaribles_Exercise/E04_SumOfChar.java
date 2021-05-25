package T04_DataTypesAndVaribles_Exercise;

import java.util.Scanner;

public class E04_SumOfChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {

            String character = scanner.nextLine();

            char input = character.charAt(0);
            sum+= input;

        }

        System.out.printf("The sum equals: %d",sum);
    }
}
