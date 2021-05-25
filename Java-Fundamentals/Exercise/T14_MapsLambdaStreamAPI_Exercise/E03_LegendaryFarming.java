package T14_MapsLambdaStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E03_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junk = new LinkedHashMap<>();
        boolean isObtained = false;

        while (!isObtained) {
            String[] inputLIne = scanner.nextLine().split("\\s+");
            for (int i = 0; i < inputLIne.length; i += 2) {
                int quantity = Integer.parseInt(inputLIne[i]);
                String item = inputLIne[i + 1].toLowerCase();
                if (keyMaterials.containsKey(item)) {
                    addToMap(keyMaterials, item, quantity);
                    isObtained = isObtained(keyMaterials, item);
                    if (isObtained) {
                        break;
                    }
                } else {
                    addToMap(junk, item, quantity);
                }
            }
        }
    }

    private static boolean isObtained(Map<String, Integer> map, String item) {
        if (map.get(item) >= 250) {
            int newQuantity = map.get(item) - 250;
            map.put(item, newQuantity);
            switch (item) {
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    break;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    break;
                case "motes":
                    System.out.println("Dragonwrath obtained!");
                    break;
            }
            return true;
        }
        return false;
    }

    private static void addToMap(Map<String, Integer> map, String item, int quantity) {

        map.putIfAbsent(item, 0);
        int newQuantity = map.get(item) + quantity;
        map.put(item, newQuantity);
    }
}
