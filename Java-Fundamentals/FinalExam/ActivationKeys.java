package FinalExamPreparation;

import java.util.Scanner;

public class ActivationKeys {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(line);

        while (!"Generate".equals(input)) {

            String[] tokens = input.split(">>>");
            String command = tokens[0];


            switch (command) {
                case "Contains":
                    line = sb.toString();
                    String substring = tokens[1];
                    if (line.contains(substring)) {
                        System.out.printf("%s contains %s%n", line, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);

                    switch (tokens[1]) {
                        case "Upper":
                            if (startIndex >= 0 && endIndex <= sb.length()) {
                                toUpperCase(sb, startIndex, endIndex);

                            }
                            break;
                        case "Lower":
                            if (startIndex >= 0 && endIndex <= sb.length()) {
                                toLowerCase(sb, startIndex, endIndex);
                            }
                            break;
                    }
                    break;
                case "Slice":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);
                    if (start >= 0 && end <= sb.length()) {
                        deleted(sb, start, end);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", sb.toString());
    }

    private static void deleted(StringBuilder sb, int start, int end) {
        sb.delete(start, end);
        System.out.println(sb.toString());
    }

    private static void toLowerCase(StringBuilder sb, int startIndex, int endIndex) {
        String lowerCase = sb.substring(startIndex, endIndex).toLowerCase();
        sb.replace(startIndex, endIndex, lowerCase);
        System.out.println(sb.toString());

    }

    private static void toUpperCase(StringBuilder sb, int startIndex, int endIndex) {
        String upperCase = sb.substring(startIndex, endIndex).toUpperCase();
        sb.replace(startIndex, endIndex, upperCase);
        System.out.println(sb.toString());
    }

}
