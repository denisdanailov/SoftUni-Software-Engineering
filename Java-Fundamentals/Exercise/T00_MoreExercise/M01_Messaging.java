package T00_MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class M01_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        List<String> digits = new ArrayList<>();
        for (String s : input) {
            digits.add(s);
        }
        int result = 0;
        for (int i = 0; i < digits.size() ; i++) {
            result = 0;
            String current = digits.get(i);
            for (int j = 0; j < current.length() ; j++) {
                result += Character.getNumericValue(current.charAt(j));
            }
            if (result <= sb.length()) {
                System.out.print(sb.charAt(result));
                sb.deleteCharAt(result);
            } else {
                int currentLength = result - sb.length();
                result = currentLength;
                System.out.print(sb.charAt(result));
                sb.deleteCharAt(result);
            }
        }
    }
}
