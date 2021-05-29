package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        LIFO -> Last In First Out -> Стек Stack
//        FIFO -> First In First Out -> Опашка Queue

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String element : input) {
            stack.push(Integer.parseInt(element));
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }


    }
}
