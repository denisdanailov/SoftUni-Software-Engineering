package T14_MapsLambdaStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E04_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       Map<String,Integer> quantityMap = new LinkedHashMap<>();
       Map<String,Double> priceMap = new LinkedHashMap<>();

       String input = scanner.nextLine();
       while (!"buy".equals(input)) {
           String[] tokens = input.split(" ");
           String product = tokens[0];
           double price = Double.parseDouble(tokens[1]);
           int quantity = Integer.parseInt(tokens[2]);

          priceMap.put(product,price);
          quantityMap.putIfAbsent(product,0);
          int newQuantity = quantityMap.get(product) + quantity;
          quantityMap.put(product,newQuantity);

           input = scanner.nextLine();
       }
        quantityMap.forEach((k,v) -> System.out.println(String.format("%s -> %.2f",k, v * priceMap.get(k))));
    }
}
