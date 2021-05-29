package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String element : input) {
            stack.push(element);
        }
        System.out.println(String.join(", ",stack));
    }
}
