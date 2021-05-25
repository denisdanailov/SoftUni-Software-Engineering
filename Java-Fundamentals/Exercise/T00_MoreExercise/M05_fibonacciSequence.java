package T00_MoreExercise;

import java.util.Scanner;

public class M05_fibonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= num ; i++) {

            int fibonacci = i * i ;
            System.out.println(fibonacci);

    }

//    private static int fibonacciSequence (int num) {
//
//        int fibonacciSequence = 0;
//        for (int i = 0; i <= num ; i++) {
//
//            int fibonacci = i * i + 1;
//            System.out.println(fibonacci);
//
//        }
//
    }
}
