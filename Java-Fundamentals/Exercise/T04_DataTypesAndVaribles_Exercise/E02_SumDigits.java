package T04_DataTypesAndVaribles_Exercise;

import java.util.Scanner;

public class E02_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < input.length() ; i++) {

            int currentNum = (int) input.charAt(i) - 48;
            sum+= currentNum;
        }
        System.out.println(sum);
    }

}
