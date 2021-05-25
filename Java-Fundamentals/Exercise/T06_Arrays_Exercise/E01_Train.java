package T06_Arrays_Exercise;

import java.util.Scanner;

public class E01_Train {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWagons = Integer.parseInt(scanner.nextLine());

        int [] trains = new int[numberOfWagons];

        int people = 0;

        for (int i = 0; i < numberOfWagons; i++) {
            trains[i] = Integer.parseInt(scanner.nextLine());
            people+=trains[i];
        }
        for (int i = 0; i <trains.length ; i++) {
            System.out.print(trains[i] + " ");

        }
        System.out.println();
        System.out.println(people);
    }
}
