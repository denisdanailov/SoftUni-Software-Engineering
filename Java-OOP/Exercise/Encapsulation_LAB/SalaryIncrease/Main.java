package Encapsulation_LAB.SalaryIncrease;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Person> people = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Person person = new Person(tokens[0],tokens[1],Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]));

            people.add(person);
        }
        double bonus = Double.parseDouble(scanner.nextLine());

        for(Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}
