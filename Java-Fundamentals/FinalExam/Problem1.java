package FinalExam;

import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder input = new StringBuilder(scanner.nextLine());

        String commands = scanner.nextLine();
        while (!"Finish".equals(commands)) {

            String[] tokens = commands.split("\\s+");

            String command = tokens[0];

            switch (command) {

                case "Replace":
                    String currentChar = tokens[1];
                    String newChar = tokens[2];
                    input = new StringBuilder(input.toString().replace(currentChar, newChar));
                    System.out.println(input.toString());
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && endIndex >= 0 && startIndex < input.length() && endIndex < input.length()) {
                        input.delete(startIndex, endIndex + 1);
                        System.out.println(input.toString());
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
                case "Make":
                    String toCase = tokens[1];

                    if (toCase.equals("Upper")) {
                        input = new StringBuilder(input.toString().toUpperCase());
                        System.out.println(input.toString());
                    }
                    if (toCase.equals("Lower")) {
                        input = new StringBuilder(input.toString().toLowerCase());
                        System.out.println(input.toString());
                    }
                    break;
                case "Check":
                    String message = tokens[1];
                    if (input.toString().contains(message)) {
                        System.out.println(String.format("Message contains %s", message));
                    } else {
                        System.out.println(String.format("Message doesn't contain %s", message));
                    }
                    break;
                case "Sum":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && endIndex >= 0 && startIndex < input.length() && endIndex < input.length()) {
                        String substring = input.substring(startIndex, endIndex + 1);
                        int asciiSum = 0;
                        for (int i = 0; i < substring.length(); i++) {
                            asciiSum += substring.charAt(i);
                        }
                        System.out.println(asciiSum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

            }

            commands = scanner.nextLine();
        }
    }
}
