package FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Matcher matcher = Pattern.compile("([#|])(?<product>[A-Z][A-Z a-z]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<nutrition>\\d+)\\1").matcher(text);


        List<String> allDays = new ArrayList<>();
        int total = 0;
        while (matcher.find()) {

            String name = matcher.group("product");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("nutrition"));

            allDays.add(String.format("Item: %s, Best before: %s, Nutrition: %d",name,date,calories));

            total += calories;

        }
        int result = total / 2000;
        System.out.println(String.format("You have food to last you for: %d days!",result));
        for (String day : allDays) {
            System.out.println(day);
        }
    }
}
