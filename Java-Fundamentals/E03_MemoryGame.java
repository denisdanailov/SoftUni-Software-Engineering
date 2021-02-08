package T00_Mid_Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        List<Integer> numbers  = new ArrayList<>();

        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
        int moves = 0;
        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            String[] tokens = command.split(" ");
            int middle = numbers.size() / 2;

            int firstOne = Integer.parseInt(tokens[0]);
            int secondOne = Integer.parseInt(tokens[1]);

          Integer firstIndex =  numbers.get(numbers.indexOf(firstOne));
//          Integer secondIndex = numbers.get(numbers.indexOf(secondOne));

          if (firstIndex.equals(firstOne) ) {
              numbers.remove(firstOne);
              numbers.remove(secondOne);

                moves++;
                System.out.printf("Congrats! You have found matching elements - %d!",moves);
            }

            if (firstOne < 0 || secondOne < 0 || firstOne > numbers.size() || secondOne > numbers.size()) {
                System.out.println("Invalid input! Adding additional elements to the board");
                numbers.add(middle,-moves);
                numbers.add(middle,-moves);

            }



            command = scanner.nextLine();
        }
    }
}
