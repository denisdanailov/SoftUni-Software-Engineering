package SetsAndMapsAdvanced_LAB;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] commands = input.split(", ");
            String command = commands[0];
            String car = commands[1];

            switch (command) {
                case "IN":
                    parking.add(car);
                    break;
                case "OUT":
                    parking.remove(car);
                    break;
            }
            input = scanner.nextLine();
        }

        if(parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parking.forEach(System.out::println);
        }

    }
}
