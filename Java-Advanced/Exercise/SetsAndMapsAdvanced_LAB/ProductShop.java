package SetsAndMapsAdvanced_LAB;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopInfo = new TreeMap<>();
        String input;
        while (!"revision".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] inputData = input.split(", ");
            String shop = inputData[0];
            String product = inputData[1];
            double price = Double.parseDouble(inputData[2]);
            shopInfo.putIfAbsent(shop, new LinkedHashMap<>());
            shopInfo.get(shop).putIfAbsent(product,price);
        }
        shopInfo.forEach((key, value) -> {
            System.out.printf("%s->%n",key);
            value.forEach((key1, value1) ->
                    System.out.printf("Product: %s, Price: %.1f%n",key1, value1));
        });
    }
}
