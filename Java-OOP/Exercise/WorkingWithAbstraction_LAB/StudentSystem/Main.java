package WorkingWithAbstraction_LAB.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"Exit".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    double grade = Double.parseDouble(tokens[3]);

                    Student student = new Student(name,age,grade);
                    System.out.println(student.createStudent(name, age, grade));
                    break;
                case "Show":
                    break;

            }


            input = scanner.nextLine();
        }
    }
}
