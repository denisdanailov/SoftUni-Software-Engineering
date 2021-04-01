package FinalExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|\\|");
        String currentCity = input[0];

        Map<String, List<Integer>> listOfCities = new LinkedHashMap<>();

        while (!currentCity.equals("Sail")) {


            addCities(listOfCities,input,currentCity);


            input = scanner.nextLine().split("\\|\\|");
            currentCity = input[0];
        }

        String[] commands = scanner.nextLine().split("=>");
        String command = commands[0];

        while (!"End".equals(command)) {

            switch (command) {
                case "Plunder":
                    String plunderedCity = commands[1];
                    int population = Integer.parseInt(commands[2]);
                    int gold = Integer.parseInt(commands[3]);
                    getPlunder(listOfCities,plunderedCity,population,gold);
                    break;

                case "Prosper":
                    String town = commands[1];
                    int prosperGold = Integer.parseInt(commands[2]);
                    getProsper(listOfCities,town,prosperGold);

                    break;
            }


            commands = scanner.nextLine().split("=>");
            command = commands[0];


        }
        printed(listOfCities);


    }

    private static void printed(Map<String, List<Integer>> listOfCities) {

        if (listOfCities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.println(String.format("Ahoy, Captain! There are %d wealthy settlements to go to:",listOfCities.size()));

            for (List<Integer> value : listOfCities.values()) {
              List<Integer> sortedList =  value.stream().sorted(Integer::compareTo).collect(Collectors.toList());
            }

            listOfCities.entrySet().stream().sorted((left, right) -> {
                int result = right.getValue().get(1).compareTo(left.getValue().get(1));
                if (result == 0) {
                    result = left.getKey().compareTo(right.getKey());
                }
                return  result;
            }).forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",entry.getKey(),
                    entry.getValue().get(0), entry.getValue().get(1)));

        }

    }

    private static void addCities(Map<String, List<Integer>> listOfCities, String[] input, String currentCity) {

        listOfCities.putIfAbsent(currentCity,new ArrayList<>());
        listOfCities.get(currentCity).add(Integer.parseInt(input[1]));
        listOfCities.get(currentCity).add(Integer.parseInt(input[2]));

    }

    private static void getProsper(Map<String, List<Integer>> listOfCities, String town, int prosperGold) {

        if (prosperGold < 0) {
            System.out.println("Gold added cannot be a negative number!");

        } else {

            int currentGold = listOfCities.get(town).get(1);
                listOfCities.get(town).set(1,currentGold + prosperGold);
            System.out.println(String.format
                    ("%d gold added to the city treasury. %s now has %d gold.",
                            prosperGold,town,listOfCities.get(town).get(1)));
        }
    }

    private static void getPlunder(Map<String, List<Integer>> listOfCities, String plunderedCity, int population, int gold) {


            int currentPopular = listOfCities.get(plunderedCity).get(0) - population;
            listOfCities.get(plunderedCity).set(0,currentPopular);


            int currentGold = listOfCities.get(plunderedCity).get(1) - gold;
            listOfCities.get(plunderedCity).set(1,currentGold);


            if (listOfCities.get(plunderedCity).get(0) <= 0 || listOfCities.get(plunderedCity).get(1) <= 0) {
                System.out.println(String.format("%s plundered! %d gold stolen, %d citizens killed.",plunderedCity,gold,population));
                System.out.println(String.format("%s has been wiped off the map!",plunderedCity));
                listOfCities.remove(plunderedCity);
            } else {
                System.out.println(String.format("%s plundered! %s gold stolen, %s citizens killed.",plunderedCity,gold,population));
            }

    }
}
