package T16_TextProcesing_Exercise;

import java.util.Scanner;

public class E02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\s+");

        String first = input[0];
        String second = input[1];

        int min = Math.min(first.length(),second.length());
        int max = Math.max(first.length(),second.length());

        int result = 0;

        for (int i = 0; i < max ; i++) {
            if (i < min) {
                result += first.charAt(i) * second.charAt(i);
            } else if (first.length() == max) {
                result += first.charAt(i);
            } else {
                result += second.charAt(i);
            }
        }
        System.out.println(result);
    }
}
