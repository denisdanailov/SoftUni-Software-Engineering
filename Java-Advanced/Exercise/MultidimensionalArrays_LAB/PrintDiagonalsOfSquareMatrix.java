package MultidimensionalArrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        fillMatrix(scanner, matrixSize, matrix);

        printLeftDiagonal(matrixSize, matrix);
        System.out.println();
        printRightDiagonal(matrixSize, matrix);


    }

    private static void printRightDiagonal(int matrixSize, int[][] matrix) {
        int counterStart = 0;
        int counterEnd = 1;
        for (int row = matrixSize - 1; row >= 0 ; row--) {
            for (int col = counterStart; col < counterEnd ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            counterStart++;
            counterEnd++;
        }
    }

    private static void printLeftDiagonal(int matrixSize, int[][] matrix) {
        for (int row = 0; row < matrixSize; row++) {
            for (int col = row; col <= row ; col++) {
                System.out.print(matrix[row][col] + " ");

            }
        }
    }

    private static void fillMatrix(Scanner scanner, int matrixSize, int[][] matrix) {
        for (int row = 0; row < matrixSize; row++) {
            int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < matrix[row].length ; col++) {
                matrix[row][col] = data[col];
            }
        }
    }
}
