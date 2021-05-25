package T00_MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class M02_PascalTriangle {
    public static void main (String [] args ) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] arrayNumbers = new int[n];

        for (int i = 0; i < arrayNumbers.length ; i++) {

            i = arrayNumbers[i];

            System.out.println(arrayNumbers[i]);
        }


    }
}
