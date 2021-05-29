package SetsAndMaps_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> minerResources = new LinkedHashMap<>();
        String input;
        int counter = 0;
        StringBuilder resource = new StringBuilder();

        while (!"stop".equals(input = scanner.nextLine())) {
            if (counter % 2 == 0) {
                resource.append(input);
            } else {
                if (minerResources.containsKey(resource.toString())) {
                    int currentQuantity = minerResources.get(resource.toString());
                    minerResources.put(resource.toString(), currentQuantity + Integer.parseInt(input));

                } else {
                    minerResources.put(resource.toString(), Integer.parseInt(input));

                }
                resource.setLength(0);
            }
            counter++;
        }
        for (var entry : minerResources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
