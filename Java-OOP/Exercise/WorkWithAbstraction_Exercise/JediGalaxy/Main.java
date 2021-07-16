package WorkWithAbstraction_Exercise.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = dimensions[0];
        int m = dimensions[1];

        int[][] matrix = new int[n][m];

        int value = 0;
        fillMatrix(n, m, matrix, value);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] playerPositions = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilPositions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilPositions[0];
            int evilCol = evilPositions[1];

            while (evilRow >= 0 && evilCol >= 0) {
                isEvilInRange(matrix, evilRow, evilCol);
                evilRow--;
                evilCol--;
            }

            int playerRow = playerPositions[0];
            int playerCol = playerPositions[1];

            while (playerRow >= 0 && playerCol < matrix[1].length) {
                sum = isPlayerInRange(matrix, sum, playerRow, playerCol);

                playerCol++;
                playerRow--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static void isEvilInRange(int[][] matrix, int evilRow, int evilCol) {
        if (evilRow >= 0 && evilRow < matrix.length && evilCol >= 0 && evilCol < matrix[0].length) {
            matrix[evilRow][evilCol] = 0;
        }
    }

    private static long isPlayerInRange(int[][] matrix, long sum, int playerRow, int playerCol) {
        if (playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[0].length) {
            sum += matrix[playerRow][playerCol];
        }
        return sum;
    }

    private static void fillMatrix(int row, int col, int[][] matrix, int value) {
        for (int n = 0; n < matrix.length; n++) {
            for (int m = 0; m < matrix[n].length; m++) {
                matrix[n][m] = value++;
            }
        }
    }
}
