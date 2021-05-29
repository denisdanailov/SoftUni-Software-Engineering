package MultidimensionalArrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOF2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = fillMatrix(scanner, rows, cols);

        printMatrix(getMaxSubMatrix2x2(matrix));
        System.out.println(getMaxSum(matrix));


    }

    public static int getMaxSum(int[][]matrix) {
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 1 ; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {

                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;

                }
            }
        }
        return maxSum;
    }

    public static int[][] getMaxSubMatrix2x2(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;


        for (int row = 0; row < matrix.length - 1 ; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {

                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];


                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        return new int[][] {
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}

        };

    }

    private static int[][] fillMatrix(Scanner scanner, int rows, int cols) {

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] numbersForMatrix = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = numbersForMatrix[col];

            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
