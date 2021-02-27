package MidExam;

import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine()) ;
        double priceOfFlour = Double.parseDouble(scanner.nextLine());
        double priceOfEgg = Double.parseDouble(scanner.nextLine());
        double priceOfApron = Double.parseDouble(scanner.nextLine());

        double countOfFlour = students;
        if (students > 4) {


            for (int i = 1; i <= students; i++) {
                if (i % 5 == 0) {
                    countOfFlour-= 1;
                }
            }
        }
        double result =  priceOfApron * (students + (Math.ceil(students * 0.20))) + ((priceOfEgg * 10) * students) + (priceOfFlour * countOfFlour);

        if (budget >= result) {
            System.out.println(String.format("Items purchased for %.2f$.",result));
        } else {
            double neededMoney = result - budget;
            System.out.println(String.format("%.2f$ more needed.",neededMoney));
        }
    }
}
