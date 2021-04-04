package FinalExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> ascii = new LinkedList<>();
        boolean isValid = false;

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            Matcher matcher = Pattern.compile("([!])(?<command>[A-Z][a-z]{2,})\\1:\\[(?<name>[A-z]{7,})\\]").matcher(input);

            if (matcher.find()) {
                isValid = true;

                String command = matcher.group("command");
                String name = matcher.group("name");

                for (int j = 0; j < name.length(); j++) {
                    ascii.add((int) name.charAt(j));

                }
                System.out.print(command + ": ");
                for (Integer integer : ascii) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }

        }
    }
}
