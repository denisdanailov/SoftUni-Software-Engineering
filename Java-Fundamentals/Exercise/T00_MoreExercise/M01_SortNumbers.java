package T00_MoreExercise;

import java.util.*;

public class M01_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int three  = Integer.parseInt(scanner.nextLine());

        List<Integer> listNumber = new ArrayList<>();
        addNumber(first,second,three,listNumber);

        sorted(listNumber);

        printNumbers(listNumber);

    }

    private static void printNumbers(List<Integer> listNumber) {
        System.out.println(listNumber.get(0));
        System.out.println(listNumber.get(1));
        System.out.println(listNumber.get(2));
    }

    private static void sorted(List<Integer> listNumber) {
        Collections.sort(listNumber);
        Collections.reverse(listNumber);
    }

    private static void addNumber(int first, int second, int three, List<Integer> listNumber) {
        listNumber.add(first);
        listNumber.add(second);
        listNumber.add(three);
    }
}
