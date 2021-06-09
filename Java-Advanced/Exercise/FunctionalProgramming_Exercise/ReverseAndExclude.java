package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.stream.Stream;


public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> digits = new ArrayList<>();

        int n =Integer.parseInt(scanner.nextLine());

        for (int i = numbers.length - 1 ; i >= 0 ; i--) {
            digits.add(numbers[i]);
        }
       digits.stream().filter(e -> e % n != 0).forEach(e -> System.out.print(e + " "));


    }
}
