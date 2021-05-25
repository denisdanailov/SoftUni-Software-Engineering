package T00_MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> digits = new ArrayList<>();
        for (String s : input) {
            digits.add(Integer.parseInt(s));
        }
        double resultLeftRacer = 0;
        double resultRightRacer = 0;

        for (int i = 0; i < digits.size() / 2 ; i++) {
            if (digits.get(i) != 0) {
                resultLeftRacer += digits.get(i);
            } else {
                resultLeftRacer *= 0.8;
            }
        }
        for (int i = digits.size() - 1; i > digits.size() / 2 ; i--) {
            if (digits.get(i) != 0) {
                resultRightRacer += digits.get(i);
            } else {
                resultRightRacer *= 0.8;
            }
        }
        if (resultLeftRacer > resultRightRacer) {
            System.out.printf("The winner is left with total time: %.1f",resultRightRacer);
        } else {
            System.out.printf("The winner is left with total time: %.1f",resultLeftRacer);
        }
    }
}
