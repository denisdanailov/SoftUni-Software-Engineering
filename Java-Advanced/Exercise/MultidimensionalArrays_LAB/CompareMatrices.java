package MultidimensionalArrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArr(scanner.nextLine());
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] firstMatrix = readMatrix(rows,cols,scanner);

        rowsAndCols = readArr(scanner.nextLine());
        rows = rowsAndCols[0];
        cols = rowsAndCols[1];

        int[][] secondMatrix = readMatrix(rows, cols, scanner);

        if (matricesAreEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static boolean matricesAreEqual(int[][] first, int[][] second) {

        if (first.length != second.length) {
            return false;
        }

        for (int row = 0; row < first.length ; row++) {
            int[] firstArray = first[row];
            int[] secondArray = second[row];

            if (firstArray.length != secondArray.length) {
                return false;
            }

            for (int col = 0; col < firstArray.length ; col++) {
                if (firstArray[col] != secondArray[col]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner) {

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArr(scanner.nextLine());
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArr(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
