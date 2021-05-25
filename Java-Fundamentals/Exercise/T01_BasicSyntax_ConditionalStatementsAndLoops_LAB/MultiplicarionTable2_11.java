package T01_BasicSyntax_ConditionalStatementsAndLoops_LAB;

import java.util.Scanner;

public class MultiplicarionTable2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());


        if (number2 > 10) {
            System.out.printf("%d X %d = %d", number, number2, number * number2);
        } else if (number2 >= 5) {
            System.out.printf("%d X %d = %d", number, number2, number * number2);
            System.out.println();
            System.out.printf("%d X 6 = %d", number,number * 6);
            System.out.println();
            System.out.printf("%d X 7 = %d", number,number * 7);
            System.out.println();
            System.out.printf("%d X 8 = %d", number,number * 8);
            System.out.println();
            System.out.printf("%d X 9 = %d", number,number * 9);
            System.out.println();
            System.out.printf("%d X 10 = %d", number,number * 10);

        } else if (number2 < 5) {

            System.out.printf("%d X 1 = %d",number,number* 1);
            System.out.println();
            System.out.printf("%d X 2 = %d",number,number* 2);
            System.out.println();
            System.out.printf("%d X 3 = %d",number,number* 3);
            System.out.println();
            System.out.printf("%d X 4 = %d",number,number* 4);
            System.out.println();
            System.out.printf("%d X 5 = %d",number,number* 5);
            System.out.println();
            System.out.printf("%d X 6 = %d",number,number* 6);
            System.out.println();
            System.out.printf("%d X 7 = %d",number,number* 7);
            System.out.println();
            System.out.printf("%d X 8 = %d",number,number* 8);
            System.out.println();
            System.out.printf("%d X 9 = %d",number,number* 9);
            System.out.println();
            System.out.printf("%d X 10 = %d",number,number * 10);

        }
    }
}
