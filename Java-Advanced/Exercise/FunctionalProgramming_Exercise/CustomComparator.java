package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> oddNumbers = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> reversed =
                Arrays.stream(numbers)
                .boxed().sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        reversed.stream().filter(e -> e % 2 != 0).forEach(oddNumbers::push);
        reversed.stream().filter(e -> e % 2 == 0).forEach(oddNumbers::push);

        for (Integer digit : oddNumbers) {
            System.out.print(digit + " ");
        }
    }
}
