package T00_MoreExercise;

import java.util.Scanner;

public class M04_DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String type = scanner.nextLine();

       switch (type) {
           case "int":
               int numInt = Integer.parseInt(scanner.nextLine());
               depending(numInt);
               break;
           case "real":
               double numDouble = Double.parseDouble(scanner.nextLine());
               depending(numDouble);
               break;
           case "string":
               String name = scanner.nextLine();
               depending(name);
               break;


       }

    }

    private static int depending( int numInt) {

        int result = numInt * 2;
        System.out.println(result);

        return result;
    }

    private static double depending( double numDouble) {

        double result = numDouble * 1.5;
        System.out.printf("%.2f",result);
        return result;
    }

    private static String depending( String name) {

        String result = "$" + name + "$";
        System.out.println(result);
        return result;
    }
}

