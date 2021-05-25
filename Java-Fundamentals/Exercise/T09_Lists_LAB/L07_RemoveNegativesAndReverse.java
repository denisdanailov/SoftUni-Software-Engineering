package T09_Lists_LAB;

import java.util.*;
import java.util.stream.Collectors;

public class L07_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();
        List<String> items =  Arrays.stream(values.split(" ")).collect(Collectors.toList());
        List<Integer> numbers = new ArrayList<>();
        List<Integer> possitivNumbers = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            numbers.add(Integer.parseInt(items.get(i)));

        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 0) {
               possitivNumbers.add(numbers.get(i));
            }
        }
        Collections.reverse(possitivNumbers);

        if (possitivNumbers.size() > 0) {
            System.out.println(possitivNumbers.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println("empty");
        }

    }
}
