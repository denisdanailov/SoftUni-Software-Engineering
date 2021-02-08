package T00_Mid_Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String s : inputArr) {
            numbers.add(Integer.parseInt(s));
        }

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "swap":
                    int indexOne =Integer.parseInt(tokens[1]);
                    int indexTwo = Integer.parseInt(tokens[2]);

                    int numberOne = numbers.get(indexOne);
                    int numberTwo = numbers.get(indexTwo);

                    numbers.remove(indexOne);
                    numbers.add(indexOne,numberTwo);
                    numbers.remove(indexTwo);
                    numbers.add(indexTwo,numberOne);


                    break;
                case "multiply":
                    int indexOneM =Integer.parseInt(tokens[1]);
                    int indexTwoM = Integer.parseInt(tokens[2]);

                    int numberOneM = numbers.get(indexOneM);
                    int numberTwoM = numbers.get(indexTwoM);

                    int result = numberOneM * numberTwoM;
                    numbers.remove(1);
                    numbers.add(1,result);
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.size() ; i++) {
                        numbers.set(i,numbers.get(i) - 1);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.print(numbers.toString().replaceAll("[\\[\\]]",""));
    }
}
