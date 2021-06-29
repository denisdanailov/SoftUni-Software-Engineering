package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] roses = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] lilies = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        fillRoses(roses, stack);
        fillLilies(lilies, queue);

        int wreath = 0;
        int storedSUm = 0;

        while (!stack.isEmpty() && !queue.isEmpty()) {

            int rosesPeek = stack.peek();
            int liliesPeek = queue.peek();
            int sum = rosesPeek + liliesPeek;

            if (sum < 15) {
                storedSUm += sum;
                removeFlowers(stack, queue);
            } else if (sum > 15) {
                while (sum > 15) {
                    sum -= 2;
                }
                if (sum == 15) {
                    wreath++;
                } else {
                    storedSUm += sum;
                }
                removeFlowers(stack, queue);
            } else {
                removeFlowers(stack, queue);
                wreath++;
            }
        }

        if (storedSUm > 15) {
            while (storedSUm >= 15) {
                storedSUm -= 15;
                wreath++;
            }
        }
        printConsole(wreath);

    }

    private static void printConsole(int wreath) {
        if (wreath >= 5) {
            System.out.println(String.format("You made it, you are going to the competition with %d wreaths!", wreath));
        } else {
            System.out.println(String.format("You didn't make it, you need %d wreaths more!", 5 - wreath));
        }
    }

    public static void removeFlowers(ArrayDeque<Integer> stack, ArrayDeque<Integer> queue) {
        stack.pop();
        queue.poll();
    }

    private static void fillLilies(int[] lilies, ArrayDeque<Integer> queue) {
        for (int lily : lilies) {
            queue.offer(lily);
        }
    }

    private static void fillRoses(int[] roses, ArrayDeque<Integer> stack) {
        for (int rose : roses) {
            stack.push(rose);
        }
    }
}
