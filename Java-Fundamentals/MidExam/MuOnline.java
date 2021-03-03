package MidExamPreparation;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentHealth = 100;
        int currentBitcoins = 0;

        String[] rooms = scanner.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {

            String[] command = rooms[i].split(" ");

            if (command[0].equals("potion")) {
                int health = Integer.parseInt(command[1]);
                int healed = toHealed(currentHealth,health);
                currentHealth = toPotion(currentHealth, health);

                System.out.println(String.format("You healed for %d hp.", healed));
                System.out.println(String.format("Current health: %d hp.", currentHealth));

            } else if (command[0].equals("chest")) {
                int bitcoins = Integer.parseInt(command[1]);
                currentBitcoins = toChest(currentBitcoins, bitcoins);

                System.out.println(String.format("You found %d bitcoins.", bitcoins));
            } else {
                int attack = Integer.parseInt(command[1]);
                String monster = command[0];

                 currentHealth -= attack;
                if (currentHealth> 0) {
                    System.out.println(String.format("You slayed %s.", monster));
                } else {
                    System.out.println(String.format("You died! Killed by %s.", monster));
                    System.out.println(String.format("Best room: %d",i+1));
                    return;
                }
            }
        }
        System.out.println("You've made it!");
        System.out.println(String.format("Bitcoins: %d",currentBitcoins));
        System.out.println(String.format("Health: %d",currentHealth));
    }

    private static int toHealed(int currentHealth, int health) {
             int totalHealth = currentHealth + health;
             int resultHealth = 0;

             if (totalHealth > 100) {
                 totalHealth-=100;
                return resultHealth = health - totalHealth;
             } else {
                 return health;
             }

    }

    private static int toChest(int currentBitcoins, int bitcoins) {

        currentBitcoins += bitcoins;
        return currentBitcoins;
    }

    private static int toPotion(int currentHealth, int health) {

        int totalHealth = currentHealth + health;
        if (totalHealth > 100) {
            totalHealth = 100;
        }
        return totalHealth;
    }
}
