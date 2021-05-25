package T08_MEthods_Exercise;

import java.util.Scanner;

public class E08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        long factorial1 = calculateFactorial(numOne);
        long factorial2 = calculateFactorial(numTwo);
        double result = factorial1 * 1.0 / factorial2;
        System.out.printf("%.2f",result);

    }
    private static long calculateFactorial (int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++ ) {
            factorial *= i;
        }
        return factorial;

    }
}
