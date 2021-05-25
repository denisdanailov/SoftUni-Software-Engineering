package T15_TextProcesing_LAB;

import java.util.Scanner;

public class L03_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firsWort = scanner.nextLine();
        String secondWort = scanner.nextLine();

        String corrected = "";
        while (secondWort.contains(firsWort)) {
            corrected = secondWort.replace(firsWort,"");
            secondWort = corrected;
        }

        System.out.println(corrected);
    }
}
