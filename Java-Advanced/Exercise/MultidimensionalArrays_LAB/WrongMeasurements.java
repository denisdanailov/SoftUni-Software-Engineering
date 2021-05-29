package MultidimensionalArrays_LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = fillMatrix(scanner, rows, 0);

        int[] coordinates = readArray(scanner);
        int wrongValue = matrix[coordinates[0]][coordinates[1]];
        List<int[]> valuesToUpdate = new ArrayList<>();

        checkMatrix(matrix, wrongValue, valuesToUpdate);

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void checkMatrix(int[][] matrix, int wrongValue, List<int[]> valuesToUpdate ) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                if (matrix[row][col] == wrongValue) {
                    valuesToUpdate.add(new int[] { row,col, getItemsSum(row, col, matrix,wrongValue) });
                }
            }
        }
        for (int[] values : valuesToUpdate) {
            matrix[values[0]][values[1]] = values[2];
        }
    }

    private static int getItemsSum(int row, int col, int[][] matrix, int wrongValue) {

        int sum = 0;

        if (row - 1 >= 0 &&  matrix[row -1][col] != wrongValue) {  // Up
            sum += matrix[row -1][col];
        }
        if (col + 1 < matrix[row].length  && matrix[row][col + 1] != wrongValue) {  // Right
            sum += matrix[row][col + 1];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue ) {    // Down
            sum += matrix[row + 1][col];
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {             //Left
            sum += matrix[row][col - 1];
        }
        return sum;
    }

    private static int[][] fillMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length ; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
