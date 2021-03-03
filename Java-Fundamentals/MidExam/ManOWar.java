package MidExamPreparation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] statusOfPiratesShip = scanner.nextLine().split(">");
        String[] statusOfWarShip = scanner.nextLine().split(">");

        List<Integer> pirateShip = new ArrayList<>();
        List<Integer> warShip = new ArrayList<>();

        for (String s : statusOfPiratesShip) {
            pirateShip.add(Integer.parseInt(s));
        }
        for (String s : statusOfWarShip) {
            warShip.add(Integer.parseInt(s));
        }

        int health = Integer.parseInt(scanner.nextLine());

        String commands = scanner.nextLine();
        while (!"Retire".equals(commands)) {
            String[] tokens = commands.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);

                    if (index >= 0 && index <= warShip.size()) {
                        warShip.set(index, warShip.get(index) - damage);

                        if (warShip.get(index) <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damages = Integer.parseInt(tokens[3]);

                    if (startIndex <= 0 && endIndex <= pirateShip.size() && startIndex < pirateShip.size() && endIndex > 0) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip.set(i, pirateShip.get(i) - damages);

                            if (pirateShip.get(i) <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int currentIndex = Integer.parseInt(tokens[1]);
                    int repairHealth = Integer.parseInt(tokens[2]);

                    if (currentIndex >= 0 && currentIndex <= pirateShip.size()) {
                        if (pirateShip.get(currentIndex) < health) {
                            int result = pirateShip.get(currentIndex) + repairHealth;
                            if (result > health) {
                                result = health;
                            }
                            pirateShip.set(currentIndex, result);
                        }
                    }
                    break;
                case "Status":
                    int count = 0;

                    for (int i = 0; i < pirateShip.size(); i++) {

                        if (pirateShip.get(i) < 0.2 * health) {
                            count++;
                        }
                    }
                    System.out.println(String.format("%d sections need repair.", count));
                    break;
            }


            commands = scanner.nextLine();
        }
        int sumPirateShip = 0;
        int sumWarShip = 0;

        for (Integer integer : pirateShip) {
            sumPirateShip += integer;
        }
        for (Integer integer : warShip) {
            sumWarShip += integer;
        }
        System.out.println(String.format("Pirate ship status: %d", sumPirateShip));
        System.out.println(String.format("Warship status: %d", sumWarShip));
    }
}
