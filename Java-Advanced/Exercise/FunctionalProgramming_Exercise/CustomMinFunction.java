package FunctionalProgramming_Exercise;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;


public class CustomMinFunction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

// Function -> 1 (slow)
        Function<int[], Integer> function = arr -> Arrays.stream(arr).min().getAsInt();
// Function -> 2 (fast)
        Function<int[], Integer> func = arr -> {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length ; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        };

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        ->1
        System.out.println(function.apply(numbers));
//       -> 2
//        System.out.println(func.apply(numbers));
    }
}
