package MidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split("\\s+");

        List<Integer> listOfNumbers = new ArrayList<>();

        for (String s : sequence) {
            listOfNumbers.add(Integer.parseInt(s));
        }


        String input = scanner.nextLine();
        while (!"Mort".equals(input)) {
            String[] command = input.split("\\s+");
            int value = Integer.parseInt(command[1]);

            switch (command[0]) {

                case "Add":
                    listOfNumbers.add(value);
                    break;
                case "Remove":

                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            if (listOfNumbers.get(i) == value) {
                                listOfNumbers.remove(listOfNumbers.get(i));
                                break;
                            }
                        }
                    break;
                case "Replace":
                        int replaceElement = Integer.parseInt(command[2]);
                        for (int i = 0; i < listOfNumbers.size(); i++) {

                            if (listOfNumbers.get(i) == value) {
                                int index = listOfNumbers.indexOf(listOfNumbers.get(i));
                              listOfNumbers.set(index,replaceElement);
                                break;
                            }
                        }
                    break;
                case "Collapse":
                    for (int i = 0; i < listOfNumbers.size() ; i++) {
                        if (listOfNumbers.get(i) < value) {
                            listOfNumbers.remove(listOfNumbers.get(i));
                            i--;
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(listOfNumbers.toString().replaceAll("[\\[\\],]",""));
    }
}
