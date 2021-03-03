package MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        List<String> sequence = new ArrayList<>(Arrays.asList(input));

        int moves = 0;
        String indexes = scanner.nextLine();
        while (!"end".equals(indexes)) {
            int firstIndex = Integer.parseInt(indexes.split(" ")[0]);
            int secondIndex = Integer.parseInt(indexes.split(" ")[1]);
            moves++;
            if (firstIndex != secondIndex && firstIndex >= 0 && secondIndex <= sequence.size()
                    && firstIndex <= sequence.size() && secondIndex >= 0) {

                if (sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                    String element = sequence.get(firstIndex);
                    sequence.remove(firstIndex);
                    if (secondIndex != 0) {
                        sequence.remove(secondIndex - 1);
                    } else {
                        sequence.remove(secondIndex);
                    }
                    System.out.printf("Congrats! You have found matching elements - %s!%n",element);

                } else {
                    System.out.println("Try again!");
                }
            } else {
                System.out.println("Invalid input! Adding additional elements to the board");
                int middle = sequence.size() / 2;
                String current = "-" + moves + "a";
                sequence.add(middle, current);
                sequence.add(middle, current);
            }
            if (sequence.isEmpty()) {
                System.out.printf("You have won in %d turns!%n",moves);
                return;
            }
            indexes = scanner.nextLine();
        }
        if (!sequence.isEmpty()) {
            System.out.printf("Sorry you lose :(%n");
            for (String s : sequence) {
                System.out.print(s + " ");
            }
        } else {
            System.out.printf("You have won in %d turns!",moves);
        }
    }
}
