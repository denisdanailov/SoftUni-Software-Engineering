package T05_Arrays_LAB;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L07_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(element -> Integer.parseInt(element)).toArray();
        if (input.length <= 1) {
            System.out.println(input[0]);
            return;
        }
        int[] numbers = new int[input.length - 1];
        for (int i = 0; i < input.length - 1; i++) {
            numbers[i] = input[i] + input[i + 1];
            for (int j = 0; j < input.length - 1; j++) {
                numbers[j] = input[j] + input[j + 1];
                input[j] = numbers[j];
            }
        }
        System.out.println(numbers[0]);
    }
}
