package T03_DataTypesAndVariables_LAB;

import java.util.Scanner;

public class L01_ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meters = Integer.parseInt(scanner.nextLine());


        double convertToKm =  (double) meters / 1000 ;

        System.out.printf("%.2f",convertToKm);
    }

}
