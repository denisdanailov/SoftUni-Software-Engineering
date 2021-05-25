package T02_BasicSyntax_Conditional_StatementsAndLoop_Exercise;

import java.util.Scanner;

public class E03_Vacantion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudent = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double totalPrice = 0;
        switch (type) {
            case "Students":
                switch (day){
                    case "Friday":
                        totalPrice=countStudent * 8.45;
                        break;
                        case "Saturday":
                            totalPrice= countStudent * 9.80;
                            break;
                    case "Sunday":
                        totalPrice= countStudent *10.46;
                        break;

                        }
                        if(totalPrice >= 30) {
                            totalPrice*= 0.85;
                        }
                break;
            case "Business":
                if (countStudent >= 100) {
                    countStudent-= 10;
                }
                switch (day) {
                    case "Friday":
                        totalPrice= countStudent * 10.90;
                        break;
                    case "Saturday":
                        totalPrice=countStudent * 15.60;
                        break;
                    case "Sunday":
                        totalPrice=countStudent * 16;
                        break;
                }

                break;
            case "Regular":

                switch (day) {
                    case "Friday":
                        totalPrice=countStudent * 15;
                        break;
                    case "Saturday":
                        totalPrice=countStudent * 20;
                        break;
                    case "Sunday":
                        totalPrice=countStudent * 22.50;
                        break;
                }

                break;

        }
        System.out.printf("Total price: %.2f",totalPrice);


    }
}
