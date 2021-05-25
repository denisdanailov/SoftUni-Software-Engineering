package T16_TextProcesing_Exercise;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        sb.append(line);

        for (int i = 0; i < line.length() ; i++) {
            char symbol = '>';

            if (line.charAt(i) == symbol) {

                char power = line.charAt(i+1);
                String value = String.valueOf(power);
                int endIndex = Integer.parseInt(value);
                sb.delete(i,i+ endIndex);

                System.out.println();

            }
        }
    }
}
