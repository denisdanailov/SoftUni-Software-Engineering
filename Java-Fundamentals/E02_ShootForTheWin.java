package T00_Mid_Exam;

import java.util.Scanner;

public class E02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");

        int[] numbers = new int[inputArr.length];

        for (int i = 0; i < inputArr.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }
        int target = 0;
        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            int index = Integer.parseInt(command);

            if (index <= numbers.length - 1) {
                int indexPlus = numbers[index];
                for (int i = 0; i < numbers.length ; i++) {
                    if (indexPlus < numbers[i] && numbers[i] != -1) {
                        numbers[i]= numbers[i] - indexPlus;
                    } else if (indexPlus >= numbers[i] && numbers[i] != -1) {
                        numbers[i] = numbers[i] + indexPlus;
                    }
                }
                numbers[index]= -1;
                target++;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",target);
        for (int i = 0; i < numbers.length  ; i++) {

            System.out.print(numbers[i]+ " ");
        }

    }
}
