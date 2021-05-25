package T07_Methods_LAB;

import java.util.Scanner;

public class L07_RepeatString {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        repeatString(str,count);


    }

    private static String repeatString(String str, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {

         result+=str;
        }
        System.out.println(result);
        return result;
    }
}
