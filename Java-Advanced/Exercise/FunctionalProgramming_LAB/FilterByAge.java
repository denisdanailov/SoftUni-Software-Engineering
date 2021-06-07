package FunctionalProgramming_LAB;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterByAge {
    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Function<String, Person> parsePerson = str -> {
          String[] tokens = str.split(", ");
          return  new Person(tokens[0], Integer.parseInt(tokens[1]));
        };

        List<Person> people = new ArrayList<>();
        while (n-- > 0) {
            people.add(parsePerson.apply(scanner.nextLine()));

        }


    }
}
