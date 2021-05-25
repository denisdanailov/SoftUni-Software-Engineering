package T07_Methods_LAB;

import java.util.Scanner;

public class L03_PrintingTriangle {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxLine = Integer.parseInt(scanner.nextLine());

        printTriangle(maxLine);

    }

    private static void printTriangle(int maxLine) {
        printTopHalf(maxLine);
        printBottomHalf(maxLine - 1);
    }


    private static void printTopHalf(int numberOfRows) {
        for (int i = 1; i <=numberOfRows ; i++) {
            printRow(1, i);
            System.out.println();
        }
    }

    private static void printBottomHalf(int longestLine) {
        for (int i = longestLine; i >=1 ; i--) {
            printRow(1,i);
            System.out.println();

        }
    }

    private static void printRow(int from, int to) {
        for (int i = from; i <= to ; i++) {
            System.out.print(i + " ");
        }
    }
}
