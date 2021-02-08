package T00_Mid_Exam;

import java.util.Scanner;

public class E01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        double taxes = 0;
        double result = 0;

        String input = scanner.nextLine();
        while (!"special".equals(input) && !"regular".equals(input)) {
            double price = Double.parseDouble(input);
            if (price <= 0 ) {
                System.out.println("Invalid price!");
            } else {
                sum+=price;
            }
            input = scanner.nextLine();
        }

        if (sum <= 0) {
            System.out.println("Invalid order!");
            return;
        }
        if (input.equals("special")) {
            double tax = sum * 0.20;
            taxes= tax;
           double priceWithTax = sum + tax;
           double percent = priceWithTax * 0.10;
           result = priceWithTax - percent;

        }
        if (input.equals("regular")) {
            double tax = sum * 0.20;
            taxes = tax;
          result = sum +tax;


        }
        System.out.println(String.format("Congratulations you've just bought a new computer!"));
        System.out.println(String.format("Price without taxes: %.2f$",sum));
        System.out.println(String.format("Taxes: %.2f$",taxes));
        System.out.println("-----------");
        System.out.println(String.format("Total price: %.2f$",result));

    }
}
