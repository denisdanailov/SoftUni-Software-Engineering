package MidExamPreparation;

import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPeople = Integer.parseInt(scanner.nextLine());
        String[] waggons = scanner.nextLine().split(" ");
        int[] lift = new int[waggons.length];

        for (int i = 0; i < lift.length; i++) {
            lift[i] = Integer.parseInt(waggons[i]);
        }
        for (int i = 0; i < lift.length; i++) {

            while (countOfPeople > 0 && i < lift.length) {

                while (lift[i] != 4) {
                    countOfPeople -= 1;
                    if (countOfPeople >= 0) {
                        lift[i] = lift[i] + 1;
                    } else {
                        break;
                    }
                }
                i++;
            }
        }
        if (countOfPeople < 0) {
            countOfPeople = 0;
        }
        if (countOfPeople == 0) {
            System.out.println("The lift has empty spots!");
            for (int i : lift) {
                System.out.print(i + " ");
            }
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", countOfPeople);
            for (int i : lift) {
                System.out.print(i + " ");
            }
        }
    }
}
