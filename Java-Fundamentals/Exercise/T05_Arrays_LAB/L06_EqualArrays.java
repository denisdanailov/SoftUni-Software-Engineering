package T05_Arrays_LAB;

import java.util.Scanner;

public class L06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstArrayString = scanner.nextLine();
        String[] firstNumbersStrings = firstArrayString.split(" ");
        int [] firstArray = new int[firstNumbersStrings.length];

        for (int i = 0; i <firstArray.length ; i++) {
            firstArray[i] = Integer.parseInt(firstNumbersStrings[i]);
        }

        String secondArrayString = scanner.nextLine();
        String[] secondNumbersStrings = secondArrayString.split(" ");
        int [] secondArray = new int[secondNumbersStrings.length];

        for (int i = 0; i <secondArray.length ; i++) {
            secondArray[i] = Integer.parseInt(secondNumbersStrings[i]);
        }

        boolean areEqual = true;
        int sum = 0;
        int differentAtIndex = - 1;

        if (firstArray.length == secondArray.length) {
            for (int i = 0; i < firstArray.length ; i++) {
                if (firstArray[i] != secondArray[i]) {

                       areEqual= false;
                       differentAtIndex = i;
                       break;


                } else {
                    sum+=firstArray[i];
                }
            }
        } else {
            areEqual = false;
        }
        if (areEqual) {
            System.out.printf("Arrays are identical. Sum: %d",sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.",differentAtIndex );
        }


    }
}
