import java.util.Scanner;

public class Python {
    static int snakeLength = 1;
    static int foodSnake = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());


        String[] commands = scanner.nextLine().split(", ");
        char[][] matrix = new char[size][size];

        int[] playerPositions = new int[2];

        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col].charAt(0);

                if (matrix[row][col] == 's') {
                    playerPositions[0] = row;
                    playerPositions[1] = col;
                }
                if (matrix[row][col] == 'f') {
                    foodSnake++;
                }
            }
        }
        boolean inTheGame = true;

        for (int i = 0; i < commands.length; i++) {

            String command = commands[i];

            while (inTheGame && foodSnake > 0) {
                if (command.equals("up")) {

                    inTheGame = moveSnake(playerPositions, matrix, -1, 0);
                    break;
                } else if (command.equals("down")) {
                    inTheGame = moveSnake(playerPositions, matrix, +1, 0);
                    break;
                } else if (command.equals("left")) {
                    inTheGame = moveSnake(playerPositions, matrix, 0, -1);
                    break;
                } else if (command.equals("right")) {
                    inTheGame = moveSnake(playerPositions, matrix, 0, +1);
                    break;
                }
            }
            if(foodSnake == 0){
                System.out.printf("You win! Final python length is %d%n", snakeLength);
                break;
            }
        }

        if(foodSnake > 0 && inTheGame){
            System.out.printf("You lose! There is still %d food to be eaten.", foodSnake);
        }
    }

    private static boolean moveSnake(int[] playerPositions, char[][] matrix, int rowModifier, int colModifier) {

        int row = playerPositions[0];
        int col = playerPositions[1];

        matrix[row][col] = '*';

        int newRol = isInBounds(row + rowModifier, matrix.length);
        int newCol = isInBounds(col + colModifier, matrix.length);

        char currentSymbol = matrix[newRol][newCol];


        if (currentSymbol == 'f') {
            matrix[newRol][newCol] = '*';
            snakeLength++;
            foodSnake--;
        } else if (currentSymbol == 'e') {
            System.out.println("You lose! Killed by an enemy!");
            return false;
        }


        matrix[newRol][newCol] = 's';
        playerPositions[0] = newRol;
        playerPositions[1] = newCol;

        return true;

    }

    private static int isInBounds(int index, int length) {
        if (index < 0) {
            index = length - 1;
        } else if (index >= length) {
            index = 0;
        }
        return index;
    }
}
