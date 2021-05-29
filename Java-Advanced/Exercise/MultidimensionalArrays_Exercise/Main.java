package MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      int[][] matrix = new int[5][];

    }

    public static void fillMatrix1(Scanner scanner, int[][] matrix, int rows, int cols) {

        for (int row = 0; row < rows ; row++) {

            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
    }

    public static void fillMatrix2(Scanner scanner, int[][] matrix, int rows, int cols) {

        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols ; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }


    public static void printMatrix(int[][]matrix, int rows, int cols) {

        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
