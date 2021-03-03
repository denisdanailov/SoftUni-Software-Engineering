package MidExamPreparation;

import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employerOne = Integer.parseInt(scanner.nextLine());
        int employerTwo = Integer.parseInt(scanner.nextLine());
        int employerThree = Integer.parseInt(scanner.nextLine());
        int countPeople = Integer.parseInt(scanner.nextLine());

        int resultOfPeople =employerOne + employerThree + employerTwo;

        int timeNeeded = 0;

        while (countPeople > 0) {
        countPeople = countPeople - resultOfPeople;
            timeNeeded++;
            if (timeNeeded % 4 == 0) {
                timeNeeded++;
            }
        }
        System.out.printf("Time needed: %dh.",timeNeeded);
    }
}
