package MidExamPreparation;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;
        while (!"special".equals(input) && !"regular".equals(input)) {

            double price = Double.parseDouble(input);
            if (price >= 0) {
                sum += price;
            } else {
                System.out.println("Invalid price!");
            }

            input = scanner.nextLine();
        }
        double taxes = sum * 0.20;
        double finalSum = sum + taxes;

        if (sum > 0) {
            switch (input) {
                case "special":
                    finalSum-= finalSum * 0.10;
                    break;
                case "regular":
                    break;
            }
        } else {
            System.out.println("Invalid order!");
            return;
        }
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n",sum);
        System.out.printf("Taxes: %.2f$%n",taxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$",finalSum);

    }
}
