package T06_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(element ->Integer.parseInt(element)).toArray();

        if (numbers.length < 1 ) {
            System.out.print(0);
            return;
        }
        boolean isEquals = false;
        for (int i = 0; i < numbers.length ; i++) {
            int leftSum = 0;
            int rightSum = 0;
//            left sum for loop
            for (int j = i - 1; j >= 0; j--) {
                leftSum += numbers[j];

            }
//            right sum for loop
            for (int j = i+1; j < numbers.length; j++) {
                rightSum += numbers[j];

            }
            if (leftSum == rightSum) {
                isEquals = true;
                System.out.print(i);
                break;
            }
        }
        if (!isEquals) {
            System.out.println("no");
        }

    }
}
