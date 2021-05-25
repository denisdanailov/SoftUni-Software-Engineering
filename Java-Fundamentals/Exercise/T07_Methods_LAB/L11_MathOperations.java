package T07_Methods_LAB;

import java.text.DecimalFormat;
import java.util.Scanner;

public class L11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        calculate(a,operator,b);
//        System.out.println(calculate(a,operator,b));
        System.out.println(new DecimalFormat("0.###").format(calculate(a,operator,b)));
    }

    public static double calculate (int a , String operator , int b) {
        double result = 0.0;
        switch (operator) {
            case "/":
                result =(double) a / b ;
                break;
            case "*":
                result = (double) a * b;
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;

        }
        return result;
    }
}
