package T18_RegularExpressions_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<product>[A-Za-z]+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> furniture = new ArrayList<>();
        double totalPrice = 0.0;
        String input = scanner.nextLine();

        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
               String product = matcher.group("product");
               double price = Double.parseDouble(matcher.group("price"));
               int quantity = Integer.parseInt(matcher.group("quantity"));

               furniture.add(product);
               totalPrice += price * quantity;
            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        furniture.forEach(e -> System.out.println(e));
        System.out.println(String.format("Total money spend: %.2f",totalPrice));

    }
}
