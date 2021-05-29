package MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = new String[rows][cols];
        fillMatrix(scanner, rows, matrix);

        String input = scanner.nextLine();
        while (!"end".equalsIgnoreCase(input)) {
            String[] command = input.split("\\s+");

            if ("swap".equals(command[0]) && command.length == 5 && Integer.parseInt(command[1])<= rows && Integer.parseInt(command[2]) <= cols
            && Integer.parseInt(command[3]) <= rows && Integer.parseInt(command[4]) <= cols) {

                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                String current1 = matrix[row1][col1];
                String current2 = matrix[row2][col2];

                for (int i = row1; i <= row1 ; i++) {
                    matrix[row1][col1] = current2;
                    for (int j = row2; j <= row2 ; j++) {
                        matrix[row2][col2] = current1;
                    }
                }
                printMatrix(matrix, rows, cols);

            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }



    }

    public static void printMatrix(String[][] matrix, int rows, int cols) {

        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, String[][] matrix) {
        for (int row = 0; row < rows; row++) {

            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
