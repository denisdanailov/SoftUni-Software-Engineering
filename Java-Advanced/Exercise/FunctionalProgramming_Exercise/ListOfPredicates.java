package FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Consumer<Integer> printer = num -> System.out.print(num + " ");
        Set<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        Predicate<Integer> tester = num -> {
            for (int divisor : divisors) {
                if (num % divisor != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n ; i++) {
            if (tester.test(i)) {
                printer.accept(i);
            }
        }
    }
}
