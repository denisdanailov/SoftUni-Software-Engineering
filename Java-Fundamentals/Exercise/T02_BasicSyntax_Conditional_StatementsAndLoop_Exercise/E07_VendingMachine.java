package T02_BasicSyntax_Conditional_StatementsAndLoop_Exercise;

import java.util.Scanner;

public class E07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String start = scanner.nextLine();
        double sum = 0;
        double priceProduct =0;

        while (!start.equals("Start")) {
            double price = Double.parseDouble(start);

            if (price != 0.1 && price != 0.2 && price != 0.5 && price != 1 && price != 2) {
                System.out.printf("Cannot accept %.2f%n",price);
                sum-= price;

            }
            sum+= price;

            start = scanner.nextLine();
        }


        while (start.equals("Start")) {

            String product = scanner.nextLine();


            switch (product) {

                case "Nuts":
                    priceProduct = 2.0;
                    break;
                case "Water":
                    priceProduct = 0.7;
                    break;
                case "Crisps":
                    priceProduct = 1.5;
                    break;
                case "Soda":
                    priceProduct = 0.8;
                    break;
                case "Coke":
                    priceProduct = 1.0;
                    break;

            }
            if (product.equals("End")) {
                System.out.printf("Change: %.2f", sum);
                break;

            } if (!product.equals("Nuts") && !product.equals("Water") && !product.equals("Crisps") && !product.equals("Soda") && !product.equals("Coke")) {
                System.out.println("Invalid product");
                System.out.printf("Change: %.2f", sum);

                break;
            }

            if (priceProduct <= sum) {
                System.out.printf("Purchased %s%n",product);
                sum-=priceProduct;
            } else if (priceProduct > sum){
                System.out.println("Sorry, not enough money");

            }

        }

    }
}
