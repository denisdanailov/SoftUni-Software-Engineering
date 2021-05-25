package T10_Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



     List<Integer> listNumbers = readInLIst(scanner);

        String input = scanner.nextLine();

        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    listNumbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    if(isValid(listNumbers,index)) {
                        listNumbers.add(index,number);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    if (isValid(listNumbers,index)) {
                        listNumbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;
                case "Shift":
                    int count = Integer.parseInt(tokens[2]);
                    if ("left".equals(tokens[1])) {
                        for (int i = 0; i < count ; i++) {
                            int temp = listNumbers.remove(0);
                            listNumbers.add(temp);
                        }

                    } else if ("right".equals(tokens[1])) {
                        for (int i = 0; i <count ; i++) {
                            int temp = listNumbers.remove(listNumbers.size() - 1);
                            listNumbers.add(0,temp);
                        }
                    }
                    break;
            }

                        input = scanner.nextLine();

        }
        printList(listNumbers);
    }
    public static void printList(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }
    }


    private static boolean isValid(List<Integer> listNumbers, int index) {
        boolean result = index >= 0 && index < listNumbers.size();
        return result;
    }



    private static List<Integer> readInLIst(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        String[] input  = scanner.nextLine().split(" ");
        for (String s : input) {
            numbers.add(Integer.parseInt(s));

        }
        return numbers;

    }


}
