package T00_Mid_Exam;

import java.util.*;

public class E02_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String inputReplace = input.replaceAll("\\|", " ");
        String[] inputArr = inputReplace.split("\\s+");


        List<String> inputLIst = new ArrayList<>();

        for (int i = 0; i < inputArr.length; i++) {
            inputLIst.add(inputArr[i]);
        }

        int potion = 100;
        int bitcoins = 0;
        int bestRoom = 0;

        for (int i = 0; i < inputLIst.size() - 1; i++) {

            String command = " ";
            if (i % 2 == 0) {
                command = inputLIst.get(i);
            } else {
                continue;
            }
            bestRoom++;
            switch (command) {
                case "potion":
                    int health = Integer.parseInt(inputLIst.get(i + 1));
                    int reference = 100 - potion;
                    if (health > reference) {
                        System.out.printf("You healed for %d hp.%n",Math.abs(reference));
                        potion+= health;
                        if (potion > 100) {
                            potion =100;
                        }
                    } else if (health < reference) {
                        potion+= health;
                        System.out.printf("You healed for %d hp.%n",health);
                    }

                    System.out.printf("Current health: %d hp.%n", potion);
                    break;
                case "chest":
                    int bitcoin = Integer.parseInt(inputLIst.get(i + 1));
                    bitcoins += bitcoin;
                    System.out.printf("You found %d bitcoins.%n", bitcoin);
                    break;
                default:
                    if (potion > 0) {
                        potion -= Integer.parseInt(inputLIst.get(i + 1));
                        if (potion <= 0) {
                            System.out.printf("You died! Killed by %s.%n", command);
                            System.out.printf("Best room: %d", bestRoom);
                            return;
                        } else {
                            System.out.printf("You slayed %s.%n", command);
                        }
                    }
            }

        }
        System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoins, potion);

    }

}
