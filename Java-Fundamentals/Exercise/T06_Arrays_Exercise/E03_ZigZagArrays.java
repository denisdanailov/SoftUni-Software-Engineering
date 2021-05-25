package T06_Arrays_Exercise;

import java.util.Scanner;

public class E03_ZigZagArrays {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfLines = Integer.parseInt(scanner.nextLine());

        int[] first = new int[numbersOfLines];
        int[] second = new int[numbersOfLines];

        for (int i = 1; i <= numbersOfLines ; i++) {

            String[] numbers = scanner.nextLine().split(" ");

            if (i % 2 == 0) {
                first[i- 1] = Integer.parseInt(numbers[1]);
                second[i- 1] =Integer.parseInt(numbers[0]);

            } else {
                first[i -1] = Integer.parseInt(numbers[0]);
                second[i -1] =Integer.parseInt(numbers[1]);
            }
        }

        for (int i = 0; i < first.length ; i++) {
            System.out.print(first[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < second.length ; i++) {
            System.out.print(second[i] + " ");
        }
    }
}
