package FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Matcher matcher = Pattern.compile("([@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1").matcher(input);

        int countMatches = 0;
        List<String> mirrorWords = new ArrayList<>();
        while (matcher.find()) {
            countMatches++;

            StringBuilder first = new StringBuilder(String.valueOf(matcher.group("first"))).reverse();
            if (String.valueOf(first).equals(matcher.group("second"))) {
                mirrorWords.add(String.format("%s <=> %s",matcher.group("first"),matcher.group("second")));
            }
        }
        if (countMatches == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", countMatches);
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.printf("The mirror words are:%n%s",String.join(", ",mirrorWords));
        }
    }
}
