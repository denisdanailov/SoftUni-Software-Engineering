package StacksAndQueues_Exercise;


import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memoryForFibonacci;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memoryForFibonacci = new long[n + 1];
        System.out.println(fibonacci(n));

    }
    public static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        if (memoryForFibonacci[n] != 0 ) {
//            имаме го изчислено
            return memoryForFibonacci[n];
        } else {
//            нямаме го в паметта, затова го добавяме!
            memoryForFibonacci[n] = fibonacci(n -1) + fibonacci(n - 2);
        }

        return fibonacci(n -1) + fibonacci( n - 2);
    }
}
