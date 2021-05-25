package T10_Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train = readInLIst(scanner);
        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");

            if ("Add".equals(tokens[0])) {
                int people = Integer.parseInt(tokens[1]);
                train.add(people);
            } else {
                int peopleToAdd = Integer.parseInt(tokens[0]);
                for (int i = 0; i <train.size() ; i++) {
                    int sum = train.get(i) + peopleToAdd;
                    if (sum<= capacity ) {
                        train.set(i,sum);
                        break;
                    }
                }
            }

                    input = scanner.nextLine();
        }
        printTrain(train);
    }

    public static void printTrain(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }

    }

    private static List<Integer> readInLIst(Scanner scanner) {
        List<Integer> train = new ArrayList<>();
        String[] input  = scanner.nextLine().split(" ");
        for (String s : input) {
            train.add(Integer.parseInt(s));

        }
        return train;
    }
}
