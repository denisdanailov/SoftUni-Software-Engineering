package FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        Matcher matcher = Pattern.compile("([=\\/])(?<destination>[A-Z][A-z]{2,})\\1").matcher(input);
        List<String> destinations = new ArrayList<>();
        int points = 0;

        while (matcher.find()) {

            String destination = matcher.group("destination");


            destinations.add(destination);
            points += destination.length();

        }
        System.out.println("Destinations: " + String.join(", ",destinations));
        System.out.println(String.format("Travel Points: %d",points));

    }
}
