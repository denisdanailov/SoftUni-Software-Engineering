package MultidimensionalArrays_LAB;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] matrix_A = new  String[rows][cols];
        fillMatrix(scanner, rows, cols, matrix_A);

        String[][] matrix_B = new  String[rows][cols];
        fillMatrix(scanner, rows, cols, matrix_B);

        String[][] matrix_C = new String[rows][cols];
        replaceElemnts(rows, cols, matrix_A, matrix_B, matrix_C);

        printMatrix(rows, cols, matrix_C);
    }

    private static void printMatrix(int rows, int cols, String[][] matrix_C) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix_C[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void replaceElemnts(int rows, int cols, String[][] matrix_A, String[][] matrix_B, String[][] matrix_C) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!matrix_A[row][col].equals(matrix_B[row][col])) {
                   matrix_C[row][col] = "*";
                } else {
                    matrix_C[row][col] = matrix_A[row][col];
                }
            }
        }
    }

    public static void fillMatrix(Scanner scanner, int rows, int cols, String[][] matrix_A) {
        for (int row = 0; row < rows; row++) {
            String[] dataMatrix_A = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix_A[row][col] = dataMatrix_A[col];
            }
        }
    }
}
