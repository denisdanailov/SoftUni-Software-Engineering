package T16_TextProcesing_Exercise;

import java.util.Scanner;

public class E06_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = scanner.nextLine();
        int power = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '>') {
                power += Integer.parseInt(String.valueOf(input.charAt(i+1)));
                    sb.append('>');
                } else if (power == 0) {
                sb.append(currentChar);
            } else {
                power--;
            }
        }
        System.out.println(sb);
    }
}
