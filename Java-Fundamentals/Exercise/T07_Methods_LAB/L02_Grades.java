package T07_Methods_LAB;

import java.util.Scanner;

public class L02_Grades {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());


        if (grade >= 2 && grade <= 2.99) {

           gradeIsFail();
        } else if (grade >= 3 && grade <= 3.49) {

            gradeIsPoor();
        } else if (grade >= 3.50 && grade <= 4.49) {

            gradeIsGood();
        } else if (grade >= 4.50 && grade <= 5.49) {

            gradeIsVeryGood();
        } else if (grade >= 5.50 && grade <= 6.00) {

            gradeIsExcellent();
        }


    }

    private static void gradeIsExcellent() {
        System.out.println("Excellent");
    }

    private static void gradeIsVeryGood() {
        System.out.println("Very good");
    }

    private static void gradeIsGood() {
        System.out.println("Good");
    }

    private static void gradeIsPoor() {
        System.out.println("Poor");
    }

    private static void gradeIsFail() {
        System.out.println("Fail");
    }

}
