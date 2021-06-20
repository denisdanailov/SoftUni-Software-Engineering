package Iterators_Comperators_Exercise.StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PersonNameComparator personNameComparator = new PersonNameComparator();
        Set<Person> studentsByName = new TreeSet<>(personNameComparator);

        PersonAgeComparator personAgeComparator = new PersonAgeComparator();
        Set<Person> studentsByAge = new TreeSet<>(personAgeComparator);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            studentsByName.add(person);
            studentsByAge.add(person);

        }
        studentsByName.forEach(System.out::println);
        studentsByAge.forEach(System.out::println);

    }
}
