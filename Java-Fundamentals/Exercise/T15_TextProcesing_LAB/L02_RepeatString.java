package T15_TextProcesing_LAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L02_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words  = scanner.nextLine().split(" ");
        List<String> result = new ArrayList<>();
        for (String word : words) {
            result.add(repeat(word,word.length()));

        }
        System.out.println(String.join("",result));

    }

        static String repeat(String s, int repeatCount) {
            String[] repeatArr = new String[repeatCount];
            for (int i = 0; i <repeatCount ; i++) {
                repeatArr[i] = s;
            }
            return String.join("",repeatArr);
    }
}
