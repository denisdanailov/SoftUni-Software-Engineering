package T01_BasicSyntax_ConditionalStatementsAndLoops_LAB;

import java.util.Scanner;

public class BackIn30Min_04 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());


        int minutesPlus30 = minutes + 30;

        if (minutesPlus30 >= 60 ) {
            minutesPlus30 -= 60;
            hours++;
        } if (hours >= 24) {
            hours = 0;
        }

        System.out.printf("%d:%02d",hours,minutesPlus30);

    }
}
