package Encapsulation_LAB.ValidationData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            try {
                Person person = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
                people.add(person);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
//     Exercise -> "First and Reserve Team"

        Team team = new Team("Arsenal");
        for (Person person : people) {
            team.addPlayer(person);
        }
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");

//        Exercise "Validation Data"  - > print

//*        people.stream().sorted((f,s)->{
//            int compResult = f.getFirstName().compareTo(s.getFirstName());
//
//            if (compResult == 0) {
//                compResult = f.getAge().compareTo(s.getAge());
//            }
//            return compResult;
//        }).forEach(System.out::println);

//*        people
//                .stream()
//                .sorted(Comparator.comparing(Inheritance_Exercise.Person::getFirstName)
//                .thenComparingInt(Inheritance_Exercise.Person::getAge))
//
//               .forEach(System.out::println);
    }
}
