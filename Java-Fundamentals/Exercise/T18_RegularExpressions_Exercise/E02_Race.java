package T18_RegularExpressions_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class E02_Race {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        Map<String, Integer> racers = new LinkedHashMap<>();

        StringBuilder sb = new StringBuilder();
        int distance = 0;

        while (!"end of race".equals(input)) {

            for (int i = 0; i < input.length(); i++) {


                if (Character.isAlphabetic(input.charAt(i))) {
                    sb.append(input.charAt(i));
                }
                if (Character.isDigit(input.charAt(i))) {
                    distance += Integer.parseInt(String.valueOf(input.charAt(i)));
                }
            }
            String racer = sb.toString();

            if (participants.contains(racer)) {
                racers.putIfAbsent(racer, 0);
                racers.put(racer, racers.get(racer) + distance);

            }
            sb.delete(0, sb.length());
            distance = 0;

            input = scanner.nextLine();
        }


        List<String> firstThree = racers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));

    }
}
