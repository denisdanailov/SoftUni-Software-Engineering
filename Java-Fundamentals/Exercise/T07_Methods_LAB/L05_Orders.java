package T07_Methods_LAB;

import java.util.Scanner;

public class L05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int countProducts = Integer.parseInt(scanner.nextLine());

        priceOfProducts(product,countProducts);

    }

    public static void priceOfProducts(String product, int count) {

        double priceProProduct = 0.00;

        switch (product) {
            case "coffee":
                priceProProduct = 1.50;
                break;
            case "water":
                priceProProduct = 1.00;
                break;
            case "coke":
                priceProProduct = 1.40;
                break;
            case "snacks":
                priceProProduct = 2.00;
                break;
        }
        double result = (double)priceProProduct* count;
        System.out.printf("%.2f",result);
    }
}



