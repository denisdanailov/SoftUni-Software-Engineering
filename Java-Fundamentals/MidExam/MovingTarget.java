package MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> sequence = new ArrayList<>();

        for (String s : input) {
            sequence.add(Integer.parseInt(s));
        }
        String item = scanner.nextLine();
        while (!"End".equals(item)) {
            String command = item.split(" ")[0];
            int index = Integer.parseInt(item.split(" ")[1]);
            int value = Integer.parseInt(item.split(" ")[2]);

            switch (command) {
                case "Shoot":
                    if (itExist(index, sequence)) {

                        int currentPower = sequence.get(index);
                        currentPower -= value;
                        if (currentPower <= 0) {
                            sequence.remove(index);
                        } else {
                            sequence.set(index, currentPower);
                        }
                    }

                    break;
                case "Add":
                    if (itExist(index, sequence)) {
                        sequence.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (itExist(index, sequence) && index + value <= sequence.size() && index - value >= 0) {
                        int removeRight = index + value;
                        int removeLeft = index - value;
                        sequence.subList(removeLeft, removeRight + 1).clear();
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            item = scanner.nextLine();
        }
        System.out.println(sequence.toString().replace("[", "")
                .replace("]", "")
                .replaceAll("[,]", "|")
                .replaceAll(" ", ""));

    }

    private static boolean itExist(int index, List<Integer> sequence) {
        if (index < sequence.size() && index >= 0) {
            return true;
        } else {
            return false;
        }

    }
}
