package T00_Mid_Exam;

import java.util.Scanner;

public class E01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfStudent = Integer.parseInt(scanner.nextLine());
        int countOfLectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        int countOfAttendances = 0;
        int maxAttended = Integer.MIN_VALUE;
        double maxBonus = Double.MIN_VALUE;

        for (int i = 0; i < countOfStudent ; i++) {

            int attendances = Integer.parseInt(scanner.nextLine());
            countOfAttendances += attendances;
            if (attendances > maxAttended) {
                maxAttended = attendances;
            }
            double totalBonus  = (double)attendances / countOfLectures * (5 + bonus);

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
            }

        }
        System.out.printf("Max Bonus: %.0f.%n",Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.",maxAttended);

    }
}
