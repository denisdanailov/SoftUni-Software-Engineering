package T10_Lists_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }

        int [] bombInfo = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int bomb = bombInfo[0];
        int power = bombInfo[1];


        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb);

            int leftBound = Math.max(index - power,0);
            int rightBound = Math.min(index + power,numbers.size() - 1);

            for (int i = rightBound; i >= leftBound ; i--) {
                numbers.remove(i);
            }

        }
       int sum = 0;
        for (Integer number : numbers) {
            sum+= number;
        }
        System.out.println(sum);
    }
}
