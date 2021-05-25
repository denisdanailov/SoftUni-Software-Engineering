package T05_Arrays_LAB;

import java.util.Scanner;

public class L01_DayOfWeek {
    public static void main(String[] args) {


        String[] dayOfWeek = new String[] {
                "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        int day = new Scanner(System.in).nextInt();

        if (1 <= day && day <= 7) {

        System.out.println(dayOfWeek[day - 1]);
        } else {
            System.out.println("Invalid day");
        }

    }
}
