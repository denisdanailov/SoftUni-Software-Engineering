package T05_Arrays_LAB;

import java.util.Scanner;

public class L04_ReverseArrayOfStrings {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();


        String[] symbolOfFirstLIne = firstLine.split(" ");


        for (int i = symbolOfFirstLIne.length - 1; i >= 0 ; i--) {
            System.out.print(" " + symbolOfFirstLIne[i]);
        }

    }
}
