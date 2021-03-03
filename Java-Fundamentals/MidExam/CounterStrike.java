package MidExamPreparation;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        int won = 0;
        while (!"End of battle".equals(command)) {
            int battle = Integer.parseInt(command);

            if (energy < battle) {
                System.out.println(String.format("Not enough energy! Game ends with %d won battles and %d energy ",won,energy));
                return;
            }
            energy-= battle;
            won++;

            if (won % 3 == 0) {
                energy+=won;
            }

            command = scanner.nextLine();
        }
        System.out.println(String.format("Won battles: %d. Energy left: %d",won,energy));
    }
}
