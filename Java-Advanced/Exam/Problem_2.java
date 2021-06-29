import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[size][size];
        int snakeLength = 1;
//        position 0 row -- position 1 col
        int[] snakePosition = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = line.toCharArray();


            if (line.contains("s")) {
                snakePosition[0] = row;
                snakePosition[1] = line.indexOf("s");
            }

        }

        for (int i = 0; i < commands.length ; i++) {

            if (commands[i].equals("up")) {
                int row = snakePosition[0];
                int col = snakePosition[1];

                int newRow = snakePosition[0] - 1;
                int newCol = snakePosition[1];

                if (matrix[newRow][newCol] == 'f') {
                    snakeLength++;

                } else if (matrix[newRow][newCol] == 'e') {
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                }
                snakePosition[0] = newRow;
                snakePosition[1] = newCol;

            } else if (commands[i].equals("down")) {
                int row = snakePosition[0];
                int col = snakePosition[1];


                int newRow = snakePosition[0] + 1;
                int newCol = snakePosition[1];

                if (matrix[newRow][newCol] == 'f') {
                    snakeLength++;

                } else if (matrix[newRow][newCol] == 'e') {
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                }
                snakePosition[0] = newRow;
                snakePosition[1] = newCol;

            } else if (commands[i].equals("right")) {

                int row = snakePosition[0];
                int col = snakePosition[1];

                int newRow = snakePosition[0] ;
                int newCol = snakePosition[1] + 1;

                if (matrix[newRow][newCol] == 'f') {
                    snakeLength++;

                } else if (matrix[newRow][newCol] == 'e') {
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                }
                snakePosition[0] = newRow;
                snakePosition[1] = newCol;

            } else if (commands[i].equals("left")) {

                int row = snakePosition[0];
                int col = snakePosition[1];

                int newRow = snakePosition[0];
                int newCol = snakePosition[1] - 1;

                if (matrix[newRow][newCol] == 'f') {
                    snakeLength++;

                } else if (matrix[newRow][newCol] == 'e') {
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                }
                snakePosition[0] = newRow;
                snakePosition[1] = newCol;
            }
        }
        System.out.println(String.format("You win! Final python length is %d",snakeLength));

    }
    private static int isInBounds(int index , int length){
        if(index < 0){
            index = length - 1;
        }else if(index >= length){
            index = 0;
        }
        return index;
    }
}
