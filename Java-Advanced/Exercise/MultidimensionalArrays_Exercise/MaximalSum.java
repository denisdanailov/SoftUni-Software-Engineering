package MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];
        int[][] matrix = new int[rows][cols];
        int maxSum = Integer.MIN_VALUE;

        fillMatrix(scanner, matrix, rows);
        int sum = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                sum =     matrix[row][col]     + matrix[row][col + 1]         + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    sum = 0;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(matrix, maxRow, maxCol);


    }

    private static void printMatrix(int[][] matrix, int maxRow, int maxCol) {
        for (int row = maxRow; row <= maxRow + 2 ; row++) {
            for (int col = maxCol; col <= maxCol + 2 ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrix(Scanner scanner, int[][] matrix, int rows) {

        for (int row = 0; row < rows ; row++) {

            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
    }
}
