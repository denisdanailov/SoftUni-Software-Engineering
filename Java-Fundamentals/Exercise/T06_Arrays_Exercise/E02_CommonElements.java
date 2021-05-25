package T06_Arrays_Exercise;

import java.util.Scanner;

public class E02_CommonElements {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String[] firstArray = firstLine.split(" ");

        String secondLine = scanner.nextLine();
        String[] secondArray = secondLine.split(" ");

        for (int i = 0; i < secondArray.length; i++) {
            String second = secondArray[i];
            for (int j = 0; j < firstArray.length; j++) {
                String first = firstArray[j];

                if (first.equals(second)) {
                    System.out.print(first+ " ");
                }
            }
        }
    }
}
