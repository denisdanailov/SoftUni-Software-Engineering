package Exams;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        int[] playerPosition = new int[2];


        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("B")) {
                playerPosition[0] = row;
                playerPosition[1] = line.indexOf("B");
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            switch (command) {
                case "left":
                    movePlayer(playerPosition, matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(playerPosition, matrix, 0, +1);
                    break;
                case "down":
                    movePlayer(playerPosition, matrix, +1, 0);
                    break;
                case "up":
                    movePlayer(playerPosition, matrix, -1, 0);
                    break;


            }
            command = scanner.nextLine();
        }

    }

    private static void movePlayer(int[] playerPosition, char[][] matrix, int rowModification, int colModification) {
//        UP row - 1
        int row = playerPosition[0];
        int col = playerPosition[1];

        int newRow = row + rowModification;
        int newCol = col + colModification;
        int flowers = 0;

        if (matrix[newRow][newCol] == 'f' && newCol <= matrix.length && newCol >= 0 && newRow >= 0 && newRow < matrix[row].length - 1) {
            flowers++;
            matrix[row][col] = '.';
            matrix[newRow][newCol] = 'B';
            playerPosition[0] = newRow;
            playerPosition[1] = newCol;
        } else if (matrix[newRow][newCol] == 'O' && newCol <= matrix.length && newCol >= 0 && newRow >= 0 && newRow <= matrix[row].length) {
            matrix[newRow][newCol] = '.';
            newRow = rowModification + rowModification;
            newCol = rowModification + rowModification;
            matrix[row][col] = '.';
            matrix[newRow][newCol] = 'B';
            playerPosition[0] = newRow;
            playerPosition[1] = newCol;

        } else if (matrix[newRow][newCol] == '.' && newCol <= matrix.length && newCol >= 0 && newRow >= 0 && newRow <= matrix[row].length) {
            matrix[row][col] = '.';
            matrix[newRow][newCol] = 'B';
            playerPosition[0] = newRow;
            playerPosition[1] = newCol;
        } else {
            if (flowers >= 5) {
                System.out.printf("The bee got lost!%n" +
                        "Great job, the bee manage to pollinate %d flowers!",flowers);
                printMatrix(matrix);
            }
            return;
        }



    }


    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
