package T10_Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = readInLIst(scanner);
        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Delete":
                    for (int i = 0; i < numbers.size() ; i++) {
                        String deleteNumber = tokens[1];
                        if (numbers.get(i).toString().equals(deleteNumber)) {
                            numbers.remove(numbers.get(i));
                        }
                    }
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(tokens[2]),Integer.parseInt(tokens[1]));

                    break;
            }
            command = scanner.nextLine();


        }
        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static List<Integer> readInLIst(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }
}
