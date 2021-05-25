package T07_Methods_LAB;


import java.util.Scanner;

public class L10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = scanner.nextLine().chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .toArray();
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int command = numbers[i];
            if (command % 2 == 0) {
                evenSum += command;
            } else {
                oddSum += command;
            }
        }
        getMultipleOfEvensAndOdds(evenSum,oddSum);

        System.out.println(getMultipleOfEvensAndOdds(evenSum,oddSum));
    }

    private static int getMultipleOfEvensAndOdds(int evenSum, int oddSum) {

        int sumOfDigits = evenSum * oddSum;

        return sumOfDigits;
    }
}
