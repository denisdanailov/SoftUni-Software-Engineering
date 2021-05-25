package T04_DataTypesAndVaribles_Exercise;

import java.util.Scanner;

public class L07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        int waterCapacity = 255;
        int quantitiesWater = 0;

        for (int i = 0; i < numberOfLines; i++) {

            int quantities = Integer.parseInt(scanner.nextLine());

            if(quantities > waterCapacity) {
                System.out.println("Insufficient capacity!");
            } else {
                waterCapacity-=quantities;
                quantitiesWater+=quantities;

            }
        }
        System.out.println(quantitiesWater);
    }
}
