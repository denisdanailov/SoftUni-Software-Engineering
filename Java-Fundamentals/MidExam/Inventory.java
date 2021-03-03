package MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split(",\\s+");
        String input = scanner.nextLine();

        List<String> collect = new ArrayList<>();

        for (String s : sequence) {
            collect.add(s);
        }
        while (!"Craft!".equals(input)) {

            String[] tokens = input.split(" ");
            String command = tokens[0];
            String item = tokens[2];
            switch (command) {
                case "Collect":
                    if (!collect.contains(item)) {
                        collect.add(item);
                    }
                    break;
                case "Drop":
                    if (collect.contains(item)) {
                        collect.remove(item);
                    }
                    break;
                case "Combine":
                    String[] split = tokens[3].split(":");
                    String oldItem = split[0];
                    String newItem = split[1];
                    if (collect.contains(oldItem)) {
                        int currentIndex = collect.indexOf(oldItem);
                        collect.add(currentIndex + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (collect.contains(item)) {
                        collect.remove(item);
                        collect.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(collect.toString().replaceAll("[\\[\\]]", ""));
    }
}
