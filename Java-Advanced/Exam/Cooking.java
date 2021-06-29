package Exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cooking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] liquids = readInput(reader);
        int[] ingredients = readInput(reader);

        ArrayDeque<Integer> stackOfLiquids = new ArrayDeque<>();
        ArrayDeque<Integer> dequeOfIngredients = new ArrayDeque<>();
        Set<String> productsChecker = new HashSet<>();

        Map<String, Integer> products =
                new java.util.TreeMap<>
                        (Map.of("Bread:", 0,
                                "Cake:", 0,
                                "Pastry:", 0,
                                "Fruit Pie:", 0));

        fillingProducts(liquids, ingredients, stackOfLiquids, dequeOfIngredients);
        cooking(stackOfLiquids, dequeOfIngredients, products, productsChecker);
        printOfConsole(stackOfLiquids, dequeOfIngredients, products, productsChecker);

    }

    private static void fillingProducts(int[] liquids, int[] ingredients, ArrayDeque<Integer> stackOfLiquids, ArrayDeque<Integer> dequeOfIngredients) {
        for (int liquid : liquids) {
            stackOfLiquids.offer(liquid);
        }
        for (int ingredient : ingredients) {
            dequeOfIngredients.push(ingredient);
        }
    }

    private static void printOfConsole(ArrayDeque<Integer> stackOfLiquids, ArrayDeque<Integer> dequeOfIngredients, Map<String, Integer> products, Set<String> allProducts) {
        if (allProducts.size() < 4) {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        } else {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }
        if (stackOfLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left:");
            StringBuilder elements = new StringBuilder();
            for (Integer stackOfLiquid : stackOfLiquids) {
                elements.append(stackOfLiquid).append(", ");
            }
            System.out.println(elements.substring(0, elements.length() - 2));
        }
        if (dequeOfIngredients.isEmpty()) {
            System.out.print("Ingredients left: none");
            System.out.println();

        } else {
            System.out.print("Ingredients left: ");
            StringBuilder elements = new StringBuilder();
            for (Integer dequeOfIngredient : dequeOfIngredients) {
                elements.append(dequeOfIngredient).append(", ");
            }
            System.out.println(elements.substring(0, elements.length() - 2));
        }

        for (var entry : products.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void cooking(ArrayDeque<Integer> stackOfLiquids, ArrayDeque<Integer> dequeOfIngredients, Map<String, Integer> products, Set<String> allProducts) {
        while (stackOfLiquids.size() > 0 && dequeOfIngredients.size() > 0) {
            int elementL = stackOfLiquids.pop();
            int elementR = dequeOfIngredients.pop();

            int sum = elementL + elementR;
            if (sum == 25) {
                products.put("Bread:", products.get("Bread:") + 1);
                allProducts.add("Bread");
            } else if (sum == 50) {
                products.put("Cake:", products.get("Cake:") + 1);
                allProducts.add("Cake");
            } else if (sum == 75) {
                products.put("Pastry:", products.get("Pastry:") + 1);
                allProducts.add("Pastry");
            } else if (sum == 100) {
                products.put("Fruit Pie:", products.get("Fruit Pie:") + 1);
                allProducts.add("Fruit Pie");
            } else {
                dequeOfIngredients.push(elementR + 3);
            }
        }
    }

    public static int[] readInput(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
