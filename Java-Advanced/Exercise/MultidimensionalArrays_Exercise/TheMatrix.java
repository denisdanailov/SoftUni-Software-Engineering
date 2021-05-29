package MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class TheMatrix {
    private static char[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        matrix =  fillMatrixWithChars(scanner, rows, cols);

        char fillChar = scanner.nextLine().charAt(0);
        String[] startDimensions = scanner.nextLine().split("\\s+");
        int startRow = Integer.parseInt(startDimensions[0]);
        int startCol = Integer.parseInt(startDimensions[1]);

        char startChar = matrix[startRow][startCol];
        matrix[startRow][startCol] = fillChar;
        replaceCharInMatrix(startRow,startCol,startChar,fillChar);

        printMatrix();
    }

    private static void printMatrix() {
        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void replaceCharInMatrix(int row, int col, char startChar, char fillChar) {
        if (row + 1 < matrix.length && matrix[row + 1][col] == startChar) {
            matrix[row + 1][col] = fillChar;
            replaceCharInMatrix(row + 1, col, startChar, fillChar);
        }

        if (row - 1 >= 0 && matrix[row -1][col] == startChar) {
            matrix[row -1][col] = fillChar;
            replaceCharInMatrix(row - 1, col, startChar, fillChar);
        }

        if (col + 1 < matrix[row].length && matrix[row][col + 1] == startChar) {
            matrix[row][col + 1] = fillChar;
            replaceCharInMatrix(row,col + 1,startChar,fillChar);
        }

        if (col - 1 >= 0 && matrix[row][col -1] == startChar) {
            matrix[row][col -1] = fillChar;
            replaceCharInMatrix(row, col-1, startChar,fillChar);
        }
    }

    private static char[][] fillMatrixWithChars(Scanner scanner, int rows, int cols) {
        char[][] matrix = new  char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }
        return matrix;
    }
}
