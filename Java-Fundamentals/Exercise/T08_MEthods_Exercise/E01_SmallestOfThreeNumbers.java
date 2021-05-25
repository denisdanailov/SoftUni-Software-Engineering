package T08_MEthods_Exercise;

import java.util.Scanner;

public class E01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int smallerFist = findSmallerNumber(firstNum,secondNum);
        int smallestNumber = findSmallerNumber(smallerFist,thirdNum);

        System.out.println(smallestNumber);
    }

    private static int findSmallerNumber(int a , int b) {
        if (a < b) {
            return a;
        }
        return b;
    }
}
