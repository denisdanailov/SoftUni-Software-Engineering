package MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize  = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        fillMatrix1(scanner, matrix, matrixSize, matrixSize);
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int row = 0; row < matrixSize ; row++) {
            for (int col = 0; col < matrixSize ; col++) {

                int currentNumber = matrix[row][col];
                if (col == row) {
                    primaryDiagonal += currentNumber;
                } if (col == matrixSize - row - 1) {
                    secondaryDiagonal += currentNumber;
                }
            }
        }
        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));

    }

    public static void fillMatrix1(Scanner scanner, int[][] matrix, int rows, int cols) {

        for (int row = 0; row < rows ; row++) {

            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
    }
}
