package T08_MEthods_Exercise;

import java.util.Scanner;

public class E07_NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        nxnMatrix(n);
    }
    public static int nxnMatrix (int n ) {

        for (int i = 1; i <= n  ; i++) {
            System.out.print(n + " ");

            for (int j = 1; j <= n - 1 ; j++) {
                System.out.print(n+ " ");
            }
            System.out.println();
        }

        return n;
    }
}
