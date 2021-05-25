package T06_Arrays_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] sequence = new int[input.length];
        for (int i = 0; i <input.length ; i++) {
            sequence[i] = Integer.parseInt(input[i]);
        }
        int counter = 1;
        int max = 0;
        int element = 0;

        for (int i = 0; i < sequence.length - 1 ; i++) {
            if (sequence[i] == sequence[i+1]) {
                counter++;
            }else {
                counter = 1;
            }
            if (max < counter) {
                max = counter;
                element = sequence[i];
            }
        }
        for (int i = 0; i < max ; i++) {
            System.out.print(element+ " ");
        }

    }
}
