package T08_MEthods_Exercise;

import java.util.Scanner;

public class E05_AddAndSubtract {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        sumOfFirstAndSecond(first,second,third);
    }

    public static int sumOfFirstAndSecond(int first,int second, int third ) {

        int result = (first + second) - third;
        System.out.println(result);
        return result;
    }

}
