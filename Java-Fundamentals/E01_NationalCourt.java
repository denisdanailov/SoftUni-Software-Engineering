package T00_Mid_Exam;

import java.util.Scanner;

public class E01_NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firsEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());

        int countPeople = Integer.parseInt(scanner.nextLine());

        int peoplePerHour = firsEmployee + secondEmployee + thirdEmployee;
        int hours = 0;

        while (countPeople > 0 ) {
            hours++;
            if (hours % 4 == 0)
                hours++;
                countPeople -= peoplePerHour;


        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
