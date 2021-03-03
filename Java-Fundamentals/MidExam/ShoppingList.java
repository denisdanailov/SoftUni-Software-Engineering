package MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("!");
        List<String> shoppingList = new ArrayList<>();

        shoppingList.addAll(Arrays.asList(input));
        String command = scanner.nextLine();

        while (!"Go Shopping!".equals(command)) {
            String type = command.split(" ")[0];
            String product = command.split(" ")[1];

            switch (type) {
                case "Urgent":
                    if (!shoppingList.contains(product)) {
                        shoppingList.add(0,product);
                    }
                    break;
                case "Unnecessary":
                    if (shoppingList.contains(product)) {
                        shoppingList.remove(product);
                    }
                    break;
                case "Correct":
                    String oldItem = command.split(" ")[1];
                    String newItem = command.split(" ")[2];
                    if (shoppingList.contains(oldItem)) {
                        shoppingList.set(shoppingList.indexOf(oldItem),newItem);
                    }
                    break;
                case "Rearrange":
                    if (shoppingList.contains(product)) {
                        shoppingList.remove(product);
                        shoppingList.add(product);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(shoppingList.toString().replaceAll("[\\[\\]]", ""));
    }
}
