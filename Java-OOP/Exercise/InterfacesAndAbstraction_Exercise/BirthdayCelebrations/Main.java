package InterfacesAndAbstraction_Exercise.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String[] tokens = input.split("\\+");

            switch (tokens[0]) {
                case "InterfacesAndAbstraction_Exercise.BirthdayCelebrations.InterfacesAndAbstraction_Exercise.MultipleImplementation.Citizen":
                    birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;
                case "InterfacesAndAbstraction_Exercise.BirthdayCelebrations.Pet":
                    birthables.add(new Pet(tokens[1], tokens[2]));
                    break;
                case "InterfacesAndAbstraction_Exercise.BirthdayCelebrations.Robot":
                    new Robot(tokens[0], tokens[1]);
                    break;

            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();

        boolean hasOutput = false;

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
                hasOutput = true;
            }
        }

        if (!hasOutput) {
            System.out.println("<no output>");
        }


    }
}
