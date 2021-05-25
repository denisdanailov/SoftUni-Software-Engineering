package T02_BasicSyntax_Conditional_StatementsAndLoop_Exercise;

import java.util.Scanner;

public class E04_PrintAndSum {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        int result = 0;

        for (int i = start; i <= end ; i++) {

            result+= i;

        }
        for (int i = start; i <=end ; i++) {

            System.out.printf("%d ",i);

        }
        System.out.printf("%nSum: %d",result);
    }
}
