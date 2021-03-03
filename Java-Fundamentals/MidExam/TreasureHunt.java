package MidExamPreparation;

import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split("\\|");
        List<String> treasure = new ArrayList<>();

        Collections.addAll(treasure, sequence);

        String input = scanner.nextLine();
        while (!"Yohoho!".equals(input)) {
            String[] command = input.split(" ");
            
            switch (command[0]) {
                case "Loot":
                    for (int i = 1; i < command.length ; i++) {
                        if (!treasure.contains(command[i])) {
                            treasure.add(0,command[i]);
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(command[1]);
                    if (dropIndex < 0 || dropIndex >= treasure.size()) {
                        break;
                    }
                    String itemToDrop = treasure.remove(dropIndex);
                    treasure.add(itemToDrop);
                    break;
                case "Steal":
                    int count = Integer.parseInt(command[1]);
                    String output = "";
                    List<String> stolenItems = new ArrayList<>();

                    if (count >= treasure.size()) {
                        output = String.join(", ",treasure);
                        System.out.println(output);
                        treasure.clear();
                    } else {

                        for (int i = 0; i < count; i++) {
                            int lastIndex = treasure.size() - 1;
                            stolenItems.add(0, treasure.remove(lastIndex));
                        }
                        output = String.join(", ", stolenItems);
                        System.out.println(output);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        if (treasure.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sumOfElements = 0;
            for (int i = 0; i < treasure.size(); i++) {
                sumOfElements+= treasure.get(i).length();
            }
            double percent = (double)sumOfElements / treasure.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.",percent);
        }
    }
}
