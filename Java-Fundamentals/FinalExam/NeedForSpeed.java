package FinalExamPreparation;

import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> cars = new TreeMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);

            cars.putIfAbsent(car,new ArrayList<>());

            cars.get(car).add(mileage);     // -> KM index 0
            cars.get(car).add(fuel);        // -> FUEL index 1
        }

        String commands = scanner.nextLine();
        while (!commands.equals("Stop")) {


            String[] tokens = commands.split(" : ");    //-> //s+
            String command = tokens[0];
            String currentCar = tokens[1];

            switch (command) {
                case "Drive":
                    int fuel = cars.get(currentCar).get(1);
                    int currentFuel = Integer.parseInt(tokens[3]);
                    int currentDistance = Integer.parseInt(tokens[2]);

                    driving(fuel,currentFuel,currentDistance,cars,currentCar);
                    break;
                case "Refuel":
                    currentFuel = Integer.parseInt(tokens[2]);
                    fuel = cars.get(currentCar).get(1);

                    refuel(cars,currentCar,currentFuel,fuel);
                    break;
                case "Revert":
                    int mileage = cars.get(currentCar).get(0);
                    int currentKm = Integer.parseInt(tokens[2]);

                    reverted(cars,currentCar,mileage,currentKm);
                    break;

            }

            commands = scanner.nextLine();
        }

        cars.
                entrySet()
                .stream()
                .sorted((l,r) -> r.getValue().get(0) - l.getValue().get(0))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",e.getKey(),e.getValue().get(0),e.getValue().get(1)));
    }

    private static void reverted(Map<String, List<Integer>> cars, String currentCar, int mileage, int currentKm) {

        int reverted = mileage - currentKm;

        if (reverted < 10000) {
            cars.get(currentCar).set(0,10000);
        } else {
            cars.get(currentCar).set(0,reverted);
            System.out.println(String.format("%s mileage decreased by %d kilometers",currentCar,currentKm));
        }

    }

    private static void refuel(Map<String, List<Integer>> cars, String currentCar, int currentFuel, int fuel) {

        int refuel = fuel + currentFuel;

        if (refuel > 75) {
            int minusFuel = refuel - 75;
            currentFuel -= minusFuel;

            cars.get(currentCar).set(1,currentFuel + fuel);
            System.out.println(String.format("%s refueled with %d liters",currentCar,currentFuel ));
        } else {

            cars.get(currentCar).set(1,refuel);
            System.out.println(String.format("%s refueled with %d liters",currentCar,currentFuel));
        }

    }

    private static void driving(int fuel, int currentFuel, int currentDistance, Map<String, List<Integer>> cars, String currentCar) {


        int distance = cars.get(currentCar).get(0);
        if (fuel < currentFuel) {
            System.out.println("Not enough fuel to make that ride");
        } else {
                cars.get(currentCar).set(0,distance + currentDistance);
                cars.get(currentCar).set(1, fuel - currentFuel);

            System.out.println(String.format("%s driven for %d kilometers. %d liters of fuel consumed.",currentCar,currentDistance,currentFuel));
        }


        if (cars.get(currentCar).get(0) >= 100000) {
            cars.remove(currentCar);

            System.out.println(String.format("Time to sell the %s!",currentCar));
        }
    }
}
