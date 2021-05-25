package T06_Arrays_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      String[] input = scanner.nextLine().split(" ");
      int number = Integer.parseInt(scanner.nextLine());
      int[] sequence = new int[input.length];

        for (int i = 0; i < input.length ; i++) {
            sequence[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i <input.length ; i++) {

            for (int j = i+1; j < input.length ; j++) {
                if (sequence[i] + sequence[j] == number) {
                    System.out.println(sequence[i] + " " + sequence[j]);
                }
            }
        }
    }
}
