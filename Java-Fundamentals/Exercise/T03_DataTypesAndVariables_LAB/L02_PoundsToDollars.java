package T03_DataTypesAndVariables_LAB;

import java.util.Scanner;

public class L02_PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());

       double convert = pounds * 1.31;

        System.out.printf("%.3f", convert);


    }

}
