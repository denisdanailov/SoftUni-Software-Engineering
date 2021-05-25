package T10_Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06_CardGame {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split(" ");
        String[] second = scanner.nextLine().split(" ");

        List<Integer> firstPlayer = new ArrayList<>();
        List<Integer> secondPlayer = new ArrayList<>();


        for (String s : first) {
            firstPlayer.add(Integer.parseInt(s));
        }
        for (String s : second) {
            secondPlayer.add(Integer.parseInt(s));
        }



        while (firstPlayer.size() >= 0 && secondPlayer.size() >= 0) {
            if (secondPlayer.size() <= 0) {
                break;
            }
            if (firstPlayer.size() <= 0) {
                break;
            }
            for (int i = 0; i < secondPlayer.size() ; i++) {
                if (secondPlayer.size() <= 0) {
                    break;
                }
                if (firstPlayer.size() <= 0) {
                    break;
                }
                int firstCard = firstPlayer.get(i);
                int secondCard = secondPlayer.get(i);

                if (firstCard > secondCard) {
                    firstPlayer.add(firstCard);
                    firstPlayer.remove(i);
                    firstPlayer.add(secondCard);
                    secondPlayer.remove(i);
                    i = i - 1;
                } else if (secondCard > firstCard) {
                    secondPlayer.add(secondCard);
                    secondPlayer.remove(i);
                    secondPlayer.add(firstCard);
                    firstPlayer.remove(i);
                    i = i - 1;
                } else {
                    secondPlayer.remove(i);
                    firstPlayer.remove(i);
                    i = i - 1;
                }
            }
        }
        if (firstPlayer.size() <= 0 ) {

            int sumSecondPLayer = 0;
            for (Integer integer : secondPlayer) {
                sumSecondPLayer+= integer;

            }
            System.out.printf("Second player wins! Sum: %d",sumSecondPLayer);
        } else if (secondPlayer.size() <= 0) {
            int sumFirstPlayer = 0;
            for (Integer integer : firstPlayer) {
                sumFirstPlayer+= integer;

            }
            System.out.printf("First player wins! Sum: %d",sumFirstPlayer);
        }
    }

}
