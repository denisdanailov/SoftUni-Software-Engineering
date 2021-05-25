package T08_MEthods_Exercise;

import java.util.*;

public class E11_ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            String[] tokens = command.split(" ");
            String action = tokens[0];

            switch (action) {
                case "exchange":
                    int currentExchangeIndex = Integer.parseInt(tokens[1]);
                    numbers = exchange(numbers, currentExchangeIndex);
                    break;
                case "max":
                    switch (tokens[1]) {
                        case "even":
                            maxEven(numbers);
                            break;
                        case "odd":
                            maxOdd(numbers);
                            break;
                    }
                    break;
                case "min":
                    switch (tokens[1]) {
                        case "even":
                            minEven(numbers);
                            break;
                        case "odd":
                            minOdd(numbers);
                            break;
                    }
                    break;
                case "first":
                    switch (tokens[2]) {
                        case "even":
                            int currentFirstEven = Integer.parseInt(tokens[1]);
                            firstEven(numbers, currentFirstEven);
                            break;
                        case "odd":
                            int currentFirstOdd = Integer.parseInt(tokens[1]);
                            firstOdd(numbers, currentFirstOdd);
                            break;
                    }
                    break;
                case "last":
                    switch (tokens[2]) {
                        case "even":
                            int currentLastEven = Integer.parseInt(tokens[1]);
                            lastEven(numbers, currentLastEven);
                            break;
                        case "odd":
                            int currentLastOdd = Integer.parseInt(tokens[1]);
                            lastOdd(numbers, currentLastOdd);
                            break;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        List<Integer> inputList = new ArrayList<>();
        for (int number : numbers) {
            inputList.add(number);
        }
        System.out.println(inputList);

    }

    private static int[] exchange(int[] numbers, int currentExchangeIndex) {
        int[] newArray = new int[numbers.length];

        if (currentExchangeIndex > numbers.length) {
            System.out.println("Invalid index");
            return numbers;

        } else {

            int x = 0;
            for (int newStart = currentExchangeIndex + 1; newStart < numbers.length; newStart++) {
                newArray[x] = numbers[newStart];
                x++;
            }
            for (int newEnd = 0; newEnd <= currentExchangeIndex; newEnd++) {
                newArray[x] = numbers[newEnd];
                x++;
            }
            return newArray;
        }

    }

    private static void lastOdd(int[] numbers, int currentLastOdd) {
        List<Integer> odds = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                odds.add(numbers[i]);
            }
        }
        Collections.reverse(odds);
        List<Integer> lastOdds = new ArrayList<>();
        if (odds.size() > 0 && currentLastOdd < odds.size()) {
            for (int i = 0; i < currentLastOdd; i++) {
                lastOdds.add(odds.get(i));
            }
            System.out.println(lastOdds);
            if (currentLastOdd > odds.size()) {
                System.out.println(odds);
            }
        } else if (odds.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println("Invalid count");
        }
    }

    private static void lastEven(int[] numbers, int currentLastEven) {
        List<Integer> evens = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evens.add(numbers[i]);
            }
        }
        Collections.reverse(evens);
        List<Integer> lastEvens = new ArrayList<>();
        if (evens.size() > 0 && currentLastEven < evens.size()) {
            for (int i = 0; i < currentLastEven; i++) {
                lastEvens.add(evens.get(i));
            }
            Collections.reverse(lastEvens);
            System.out.println(lastEvens);
            if (currentLastEven > evens.size()) {
                System.out.println(evens);
            }
        } else if (evens.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println("Invalid count");
        }
    }


    private static void firstOdd(int[] numbers, int currentOdd) {
        List<Integer> odds = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                odds.add(numbers[i]);
            }
        }
        List<Integer> firstOdds = new ArrayList<>();
        if (odds.size() > 0 && currentOdd < odds.size()) {
            for (int i = 0; i < currentOdd; i++) {
                firstOdds.add(odds.get(i));
            }
            System.out.println(firstOdds);
        } else {
            System.out.println(odds);
        }
        if (odds.isEmpty()) {
            System.out.println("[]");
        }
        if(currentOdd > firstOdds.size()) {
            System.out.println("Invalid count");
        }
    }

    private static void firstEven(int[] numbers, int currentEven) {
        List<Integer> evens = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evens.add(numbers[i]);
            }
        }
        List<Integer> firstEvens = new ArrayList<>();
        if (evens.size() > 0 && currentEven < evens.size()) {
            for (int i = 0; i < currentEven; i++) {
                firstEvens.add(evens.get(i));
            }
            System.out.println(firstEvens);
        } else {
            System.out.println(evens);
        }
        if (evens.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println("Invalid count");
        }
    }

    private static void minOdd(int[] numbers) {
        List<Integer> minOdd = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                minOdd.add(numbers[i]);
            }
        }
        if (minOdd.size() > 0) {
            Integer integer = Collections.min(minOdd);
            int index = minOdd.indexOf(integer);
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    private static void maxOdd(int[] numbers) {
        List<Integer> maxOdd = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                maxOdd.add(numbers[i]);
            }
        }
        if (maxOdd.size() > 0) {
            Integer integer = Collections.max(maxOdd);
            int index = maxOdd.indexOf(integer);
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    private static void minEven(int[] numbers) {
        List<Integer> minEven = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                minEven.add(numbers[i]);
            }
        }
        if (minEven.size() > 0) {
            Integer integer = Collections.min(minEven);
            int index = minEven.indexOf(integer);
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }

    }

    private static void maxEven(int[] numbers) {
        List<Integer> maxEven = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                maxEven.add(numbers[i]);
            }
        }
        if (maxEven.size() > 0) {
            Integer integer = Collections.max(maxEven);
            int index = maxEven.indexOf(integer);
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }


    }

}
