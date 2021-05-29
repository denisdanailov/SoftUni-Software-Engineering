package SetsAndMapsAdvanced_LAB;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> infoTable = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            infoTable.putIfAbsent(continent, new LinkedHashMap<>());
            infoTable.get(continent).putIfAbsent(country,new ArrayList<>());
            infoTable.get(continent).get(country).add(city);
        }
        for (var listInfo : infoTable.entrySet()) {
            String continent = listInfo.getKey();
            LinkedHashMap<String, List<String>> countrys = listInfo.getValue();

            System.out.println(continent + ":");
            for (var country : countrys.entrySet()) {

                System.out.println("  " + country.getKey() + " -> " + String.join(", ", country.getValue()));
            }
        }
    }
}
