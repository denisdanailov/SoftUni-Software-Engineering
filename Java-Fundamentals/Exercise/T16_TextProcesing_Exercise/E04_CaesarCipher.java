package T16_TextProcesing_Exercise;

import java.util.Scanner;

public class E04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length() ; i++) {

        char symbol = text.charAt(i);
        sb.append( (char) (symbol +3));
        }

        System.out.println(sb.toString());
    }
}
