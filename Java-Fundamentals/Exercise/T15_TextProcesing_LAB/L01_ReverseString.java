package T15_TextProcesing_LAB;

import java.util.Scanner;

public class L01_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        while (!"end".equals(input)) {

            sb.append(input);
            sb.reverse();
            System.out.printf("%s = %s%n",input,sb.toString());

            sb.delete(0,sb.length());
            input = scanner.nextLine();
        }
    }
}
