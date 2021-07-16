package WorkWithAbstraction_Exercise.CardWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String power = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = new Card(SuitPower.valueOf(suit), RankPower.valueOf(power));

        System.out.printf("Card name: %s of %s; Card power: %d", card.getRankPower(), card.getSuitPower(), card.getPower());

    }
}
