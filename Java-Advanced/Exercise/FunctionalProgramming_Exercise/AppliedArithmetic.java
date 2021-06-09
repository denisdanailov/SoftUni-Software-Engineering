package FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //"add" -> adds 1; приемам масив, връщам масив
        Function<int[], int[]> add = array -> Arrays.stream(array).map(e -> e += 1).toArray();
        // "multiply" -> multiplies by 2; приемам масив, променям масив
        Function<int[], int[]> multiply = array -> Arrays.stream(array).map(e -> e *= 2).toArray();
        // "subtract" -> subtracts 1;
        Function<int[], int[]> subtract = array -> Arrays.stream(array).map(e -> e -= 1).toArray();
        // "print" -> prints; приема масив -> печата
        Consumer<int[]> print = array -> Arrays.stream(array).forEach(e -> System.out.print(e + " "));


        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while(!command.equals("end")) {
            //add, multiply, subtract, print
            switch(command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }

    }
}
