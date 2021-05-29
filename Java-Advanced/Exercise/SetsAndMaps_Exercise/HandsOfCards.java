package SetsAndMaps_Exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();
        String input;
        while (!"joker".equalsIgnoreCase(input = scanner.nextLine())) {
            String name = input.split(": ")[0];
            String[] inputCards = input.split(": ")[1].split(", ");

            Set<String> cards = new HashSet<>();
            Collections.addAll(cards, inputCards);

            if (!players.containsKey(name)) {
                players.put(name, cards);
            } else {
                Set<String> currentCards = players.get(name);
                currentCards.addAll(cards);
                players.put(name, currentCards);
            }
        }
        for (var player : players.entrySet()) {
            int points = getCardPoints(player.getValue());
            System.out.println(player.getKey() + ": " + points);
        }
    }

    private static int getCardPoints(Set<String> cards) {
        int sum = 0;
        Map<Character, Integer> pointsValues = getPointsValues();
        for (String card : cards) {
            int points = 0;
            if (card.contains("10")) {
                char strength = card.charAt(2);
                points = 10 * pointsValues.get(strength);
            } else {
                char number = card.charAt(0);
                char strength = card.charAt(1);
                points = pointsValues.get(strength) * pointsValues.get(number);
            }
            sum += points;
        }
        return sum;
    }

    private static Map<Character, Integer> getPointsValues() {
        Map<Character, Integer> points = new HashMap<>();
        points.put('1', 1);
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);

        return points;
    }
}
