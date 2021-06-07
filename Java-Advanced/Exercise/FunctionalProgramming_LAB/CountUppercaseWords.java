package FunctionalProgramming_LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isStartingWithUppercase = s -> Character.isUpperCase(s.charAt(0));

        Consumer<String> print = s -> System.out.println(s);

        List<String> uppercaseStrings = Arrays.stream(scanner.nextLine().split(" "))
                .filter(isStartingWithUppercase)
                .collect(Collectors.toList());

        System.out.println(uppercaseStrings.size());
        uppercaseStrings.forEach(s -> print.accept(s));

    }
}
