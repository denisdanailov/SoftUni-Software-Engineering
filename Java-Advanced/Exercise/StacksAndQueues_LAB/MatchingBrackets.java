package StacksAndQueues_LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> indexesOfBrackets = new ArrayDeque<>();

        for (int index = 0; index < input.length() ; index++) {

            char symbol = input.charAt(index);

                if (symbol == '(') {
                    indexesOfBrackets.push(index);

                } else if (symbol == ')') {
                    System.out.println(input.substring(indexesOfBrackets.pop(), index + 1));
            }
        }
    }
}
