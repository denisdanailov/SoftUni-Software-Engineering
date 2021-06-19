package Generics_Exercise.GenericBox;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<String> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {
            String text = scanner.nextLine();
            box.add(text);
        }
        int[] swapIndexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        box.swap(swapIndexes[0],swapIndexes[1]);
        System.out.println(box);

    }
}
