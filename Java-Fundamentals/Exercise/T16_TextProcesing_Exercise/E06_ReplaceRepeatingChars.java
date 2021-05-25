package T16_TextProcesing_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
       StringBuilder sb = new StringBuilder();
       char base = input.charAt(0);
        sb.append(base);
        for (int i = 0; i < input.length()  ; i++) {
            String symbol = String.valueOf(input.charAt(i));
                char currentChar = input.charAt(i);
                if (currentChar != base ) {
                    sb.append(currentChar);
                    base=currentChar;
                }
         }
        System.out.println(sb);
    }
}
