package T00_Mid_Exam;

import java.util.Scanner;

public class E01_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        int wonBattles = 0;

        String command = scanner.nextLine();
        while (!"End of battle".equals(command)) {
            int distance = Integer.parseInt(command);
            if (initialEnergy < distance) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",wonBattles,initialEnergy);
                return;
            }

            initialEnergy-= distance;
            wonBattles++;


            if (wonBattles % 3 == 0) {
                initialEnergy+=wonBattles;
            }

            command = scanner.nextLine();

        }
        System.out.printf("Won battles: %d. Energy left: %d",wonBattles,initialEnergy);
    }
}
