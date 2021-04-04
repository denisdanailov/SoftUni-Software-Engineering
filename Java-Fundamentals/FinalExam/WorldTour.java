package FinalExamPreparation;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        String commands = scanner.nextLine();



        while (!"Travel".equals(commands)) {
            String[] tokens = commands.split(":");

            String command = tokens[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String string = tokens[2];

                    if (index >= 0 && index < input.length()) {
                        input.insert(index, string);
                    }
                    System.out.println(input.toString());
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && endIndex >=0 && startIndex < input.length() && endIndex < input.length()) {
                        input.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(input.toString());
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    input = new StringBuilder(input.toString().replace(oldString,newString));

                    System.out.println(input);
                    break;
            }

            commands = scanner.nextLine();
        }
        System.out.println(String.format("Ready for world tour! Planned stops: %s",input.toString()));
    }
}
