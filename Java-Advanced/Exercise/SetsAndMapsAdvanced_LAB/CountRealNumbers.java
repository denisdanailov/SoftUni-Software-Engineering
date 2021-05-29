package SetsAndMapsAdvanced_LAB;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double, Integer> digits = new LinkedHashMap<>();

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        for (double value : values) {
            if (!digits.containsKey(value)) {
                digits.put(value,1);
            } else {
                digits.put(value, digits.get(value) + 1);
            }

        }
        for (Double key : digits.keySet()) {
            System.out.println(String.format("%.1f -> %d",key,digits.get(key)));
        }
    }
}
