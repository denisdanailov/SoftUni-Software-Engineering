package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split("\\s+");
        int[] numbers = new int[sequence.length];

        for (int i = 0; i <sequence.length ; i++) {
            numbers[i] = Integer.parseInt(sequence[i]);
        }
        int targets = 0;
        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            int index = Integer.parseInt(command);

            if (index <= numbers.length - 1 && index >= 0) {
                int currentIndex = numbers[index];
                numbers[index] = -1;
                for (int i = 0; i < numbers.length ; i++) {
                    if (numbers[i] != -1) {
                        if (numbers[i] <= currentIndex) {
                            int resultPlus = numbers[i] + currentIndex;
                            numbers[i] = resultPlus;
                        } else {
                            int resultMinus = numbers[i] - currentIndex;
                            numbers[i] = resultMinus;
                        }
                    }
                }
                targets++;
            }

            command = scanner.nextLine();
        }
        System.out.print(String.format("Shot targets: %d -> ",targets));
        System.out.print(Arrays.toString(numbers).replaceAll("[\\[\\],]",""));
    }
}
