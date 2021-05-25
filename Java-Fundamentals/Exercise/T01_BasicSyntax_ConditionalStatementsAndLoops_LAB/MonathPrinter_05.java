package T01_BasicSyntax_ConditionalStatementsAndLoops_LAB;

import java.util.Scanner;

public class  MonathPrinter_05 {
    public static void main (String [] args ) {
        Scanner scanner = new Scanner(System.in);

        int monath = Integer.parseInt(scanner.nextLine());

       if (monath == 1 ) {
           System.out.println("January");
        } else if (monath == 2 ) {
           System.out.println("February");
       } else if (monath == 3 ) {
           System.out.println("March");
       } else if (monath == 4) {
           System.out.println("April");
       } else if (monath == 5 ) {
           System.out.println("May");
       } else if (monath == 6) {
           System.out.println("June");
       } else if (monath == 7) {
           System.out.println("July");
       } else if (monath == 8) {
           System.out.println("August");
       } else if (monath == 9) {
           System.out.println("September");
       } else if (monath == 10) {
           System.out.println("October");
       } else if (monath == 11) {
           System.out.println("November");
       } else if (monath == 12) {
           System.out.println("December");
       } else  {
           System.out.println("Error!");
       }
    }
}
