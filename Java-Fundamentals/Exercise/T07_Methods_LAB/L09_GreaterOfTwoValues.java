package T07_Methods_LAB;

import java.util.Scanner;

public class L09_GreaterOfTwoValues {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                getMax(firstNum,secondNum);
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                getMax(firstChar,secondChar);
                break;
            case "string":
                String firstString = scanner.next();
                String SecondString = scanner.next();
                getMax(firstString,SecondString);
                break;

        }



    }
    public static int getMax(int firstNum, int secondNum) {
        int getMax = 0;
        if (firstNum > secondNum) {
            getMax = firstNum;
        } else {
            getMax= secondNum;
        }
        System.out.println(getMax);
        return getMax;

    }
    public static char getMax(char first , char second) {
        char getMax = ' ';
        if (first > second) {
            getMax= first;
        } else {
            getMax = second;
        }
        System.out.println(getMax);
        return getMax;
    }

    public static String getMax(String first, String second) {
       String current = "";
       if (first.compareTo(second) >= 0) {
           System.out.println(first);
           current = first;
       } else {
           System.out.println(second);
          current = second;
       }
        return current;
    }

}
