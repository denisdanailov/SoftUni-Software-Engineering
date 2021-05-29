package SetsAndMapsAdvanced_LAB;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, double[]> graduationList = new TreeMap<>();
        for ( int i = 0 ; i < n  ; i++) {

            String name = scanner.nextLine();
            double[] grade = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            graduationList.putIfAbsent(name,grade);
        }
        String pattern = "#.#####";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        for (var students : graduationList.entrySet()) {
            double avg = Arrays.stream(students.getValue()).average().orElse(0);
            String format = decimalFormat.format(avg);
            System.out.printf("%s is graduated with %s%n", students.getKey(),format);
        }
    }
}
