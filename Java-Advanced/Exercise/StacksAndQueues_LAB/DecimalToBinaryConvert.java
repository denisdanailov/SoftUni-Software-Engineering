package StacksAndQueues_LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> toBinary = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.println(decimalNumber);
        } else {
            toBinary.push(decimalNumber % 2);
            decimalNumber /= 2;
        }
        while (!toBinary.isEmpty()) {
            System.out.print(toBinary.pop());
        }
    }
}
