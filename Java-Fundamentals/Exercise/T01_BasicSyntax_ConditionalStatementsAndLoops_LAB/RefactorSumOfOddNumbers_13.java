package T01_BasicSyntax_ConditionalStatementsAndLoops_LAB;

import java.util.Scanner;

public class RefactorSumOfOddNumbers_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i <n ; i++) {

            int result = 2 * i + 1;

            System.out.println(result);
            sum += result;


        }
        System.out.printf("Sum: %d", sum);
    }
}
