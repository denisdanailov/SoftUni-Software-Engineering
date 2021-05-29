package MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        char startLetter = 'a';
        for (int row = 0; row < matrix.length ; row++) {

            for (int col = 0; col < cols ; col++) {
                matrix[row][col] = "" + startLetter + (char)(startLetter + col) + startLetter;
            }
            startLetter = (char)(startLetter + 1);
        }

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
