package T09_Lists_LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String values = scanner.nextLine();
        List<String> numbers = Arrays.stream(values.split(" ")).collect(Collectors.toList());

        List<Integer> nums = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        List<Integer> filterToBig = new ArrayList<>();
        List<Integer> filterToSmall = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            nums.add(Integer.parseInt(numbers.get(i)));
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Contains":
                    boolean isFindet = true;
                    for (int i = 0; i < numbers.size(); i++) {
                        if (tokens[1].equals(numbers.get(i))) {
                            System.out.println("Yes");
                            isFindet = false;
                            break;
                        }
                    }
                    if (isFindet) {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    switch (tokens[1]) {
                        case "odd":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (nums.get(i) % 2 != 0) {
                                    evens.add(nums.get(i));
                                }
                            }
                            System.out.println(evens.toString().replaceAll("[\\[\\],]", ""));
                            break;
                        case "even":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (nums.get(i) % 2 == 0) {
                                    odds.add(nums.get(i));
                                }
                            }
                            System.out.println(odds.toString().replaceAll("[\\[\\],]", ""));
                            break;

                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i <nums.size() ; i++) {
                        sum+=nums.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    switch (tokens[1]) {
                        case ">=":
                            for (int i = 0; i < nums.size() ; i++) {
                                String current = tokens[2];
                                if (Integer.parseInt(current) <= nums.get(i) ) {
                                    filterToBig.add(nums.get(i));
                                }
                            }
                            System.out.println(filterToBig.toString().replaceAll("[\\[\\],]", ""));
                            break;
                        case "<" :
                            for (int i = 0; i < nums.size(); i++) {
                                int current = Integer.parseInt(tokens[2]);
                                if (current > nums.get(i)) {
                                    filterToSmall.add(nums.get(i));
                                }
                            }
                            System.out.println(filterToSmall.toString().replaceAll("[\\[\\],]", ""));
                            break;
                    }

            }

            command = scanner.nextLine();
        }
    }
}
