package FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"Party!".equals(input = scanner.nextLine())) {
            String[] commands = input.split("\\s+");

            Predicate<String> predicate = getPredicate(commands[1], commands[2]);

            if (predicate != null) {
                int count = people.size();
                for (int i = 0; i < people.size(); i++) {
                    if (count-- == 0) {
                        break;
                    }
                    if (predicate.test(people.get(i))) {
                        if (commands[0].equals("Remove")) {
                            people.remove(i);
                            i--;
                        } else {
                            people.add(people.get(i));
                        }
                    }
                }
            }
        }
        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(people.toString().replaceAll("[\\[\\]]",""));
            System.out.print(" are going to the party!");
        }

    }

    private static Predicate<String> getPredicate(String command, String n) {
        switch (command) {
            case "Length":
                return x -> x.length() == Integer.parseInt(n);
            case "StartsWith":
                return x -> x.startsWith(n);
            case "EndsWith":
                return x -> x.endsWith(n);
        }
        return null;
    }
}
