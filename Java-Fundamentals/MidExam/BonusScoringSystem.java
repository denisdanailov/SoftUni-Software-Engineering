package MidExamPreparation;

import java.util.Scanner;
import java.util.TreeMap;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfStudents = Integer.parseInt(scanner.nextLine());
        int countOfLectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        TreeMap<Double,Integer> listOfStudents = new TreeMap<>();
        for (int i = 0; i < countOfStudents ; i++) {

            int countOfAttendances = Integer.parseInt(scanner.nextLine());
            double totalBonus = (double) countOfAttendances / countOfLectures * (5 + bonus);

            listOfStudents.put(totalBonus,countOfAttendances);
        }

        double maxBonus = listOfStudents.keySet().stream().max(Double::compare).get();
        int maxAttendances = listOfStudents.values().stream().max(Integer::compare).get();

        System.out.printf("Max Bonus: %.0f.%n",Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.",maxAttendances);
    }
}
