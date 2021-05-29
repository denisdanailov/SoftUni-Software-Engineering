package MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = new int[size][size];

        if (type.equalsIgnoreCase("A")) {
            fillMatrixWithTyp_A(matrix,size, size);

        } else if(type.equalsIgnoreCase("B")) {
            fillMatrixWithTyp_B(matrix,size,size);

        }
        printMatrix(matrix,size,size);

    }

    public static void fillMatrixWithTyp_A (int[][] matrix, int rows, int cols ) {
        int counter = 1;

        for (int col = 0; col < cols ; col++) {
            for (int row = 0; row < rows ; row++) {
                matrix[col][row] = counter++;
            }
        }
    }

    public static void fillMatrixWithTyp_B (int[][] matrix, int rows, int cols) {
        int counter = 1;

        for (int col = 0; col < cols; col++) {

            if (col % 2 == 0) {
                for (int row = 0; row < rows ; row++) {
                    matrix[col][row] = counter++;
                }
            } else {
                for (int row = rows - 1; row >= 0 ; row--) {
                    matrix[col][row] = counter++;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {

        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }
}
