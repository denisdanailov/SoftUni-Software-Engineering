package SetsAndMaps_Exercise;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> chars = new TreeMap<>();
        String input = scanner.nextLine();

        for (int i = 0; i <= input.length() - 1 ; i++) {
            char currentSymbol = input.charAt(i);
            if (!chars.containsKey(currentSymbol)) {
                chars.put(currentSymbol, 1);
            } else {
                int currentCount = chars.get(currentSymbol);
                chars.put(currentSymbol, currentCount + 1);
            }
        }
        for (var character : chars.entrySet()) {
            System.out.println(character.getKey() + ": " + character.getValue() +" time/s");
        }
    }
}
