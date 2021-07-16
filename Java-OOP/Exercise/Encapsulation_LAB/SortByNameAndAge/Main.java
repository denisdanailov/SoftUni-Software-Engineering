package Encapsulation_LAB.SortByNameAndAge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0],tokens[1],Integer.parseInt(tokens[2]));

            people.add(person);
        }
//*        people.stream().sorted((f,s)->{
//            int compResult = f.getFirstName().compareTo(s.getFirstName());
//
//            if (compResult == 0) {
//                compResult = f.getAge().compareTo(s.getAge());
//            }
//            return compResult;
//        }).forEach(System.out::println);

        people
                .stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                .thenComparingInt(Person::getAge))
                .forEach(System.out::println);
    }
}
