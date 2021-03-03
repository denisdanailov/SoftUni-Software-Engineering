package MidExamPreparation;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfDays = Integer.parseInt(scanner.nextLine());
        int plunderForDay = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double currentPlunder = 0;

        for (int i = 1; i <= countOfDays ; i++) {

            currentPlunder+= plunderForDay;

            if (i % 3 == 0) {
                currentPlunder+=  0.5 * plunderForDay;
            }
            if (i % 5 == 0) {
                currentPlunder= (double) currentPlunder * 0.7;
            }
        }
        if (currentPlunder >= expectedPlunder) {
            System.out.println(String.format("Ahoy! %.2f plunder gained.",currentPlunder));
        } else {
           double percentOfPlunder = (currentPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.",percentOfPlunder);
        }
    }
}
