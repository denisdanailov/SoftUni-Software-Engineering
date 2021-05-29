package MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = fillMatrix(rows, cols, scanner);

        HashMap<Integer,Integer> dataMatrix = new HashMap<>();



    }
    
    private static int[][] fillMatrix(int rows, int cols, Scanner scanner) {

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length ; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
