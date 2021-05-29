package MultidimensionalArrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getSum(scanner, rows, cols, matrix));
    }

    private static int getSum(Scanner scanner, int rows, int cols, int[][] matrix) {
        int sumOfMatrixElements = 0;
        for (int row = 0; row < rows; row++) {
            int[] data = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = data[col];
                sumOfMatrixElements += data[col];
            }

        }
        return sumOfMatrixElements;
    }
}
