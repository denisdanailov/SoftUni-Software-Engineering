package FinalExamPreparation;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRatings = new TreeMap<>();

        for (int i = 0; i < n ; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plantName = input[0];
            int rarity = Integer.parseInt(input[1]);


            plantsRarity.put(plantName,rarity);

            plantsRatings.putIfAbsent(plantName,new ArrayList<>());
        }
        String commands = scanner.nextLine();
        while (!"Exhibition".equals(commands)) {
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];

            boolean isValid = false;

            switch (command) {
                case "Rate:":
                    String plant = tokens[1];

                    double rating = Double.parseDouble(tokens[3]);
                    plantsRatings.get(plant).add(rating);
                    isValid = true;
                    break;
                case "Update:":
                    plant = tokens[1];
                    int rarity = Integer.parseInt(tokens[3]);
                    plantsRarity.put(plant,rarity);
                    isValid = true;
                    break;
                case "Reset:":
                    plant = tokens[1];
                    plantsRatings.get(plant).clear();
                    isValid = true;
                    break;

            }
            if (!isValid) {
                System.out.println("error");
            }
            commands = scanner.nextLine();
        }


        System.out.println("Plants for the exhibition:");

        plantsRarity.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                .thenComparingDouble(x -> plantsRatings.get(x.getKey()).stream()
                .mapToDouble(Double::doubleValue)
                .average().orElse(0.0))
                .reversed())
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(),e.getValue(),
                        plantsRatings.get(e.getKey()).stream().mapToDouble(Double::doubleValue)
                                .average().orElse(0.00)));
    }
}
