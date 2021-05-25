package T04_DataTypesAndVaribles_Exercise;

import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class E05_PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int beginNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());



        for (int i = beginNum; i <= endNum; i++) {

            System.out.print((char)i+" ");
        }
    }
}
