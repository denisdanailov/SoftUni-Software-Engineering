package FunctionalProgramming_LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> addVat = x -> x * 1.2;
        List<Double> pricesWithVat = Arrays.stream(scanner.nextLine().split(", "))
                .map(s -> Double.parseDouble(s))
                .map(e -> addVat.apply(e))
                .collect(Collectors.toList());

        System.out.println("Prices with VAT!");
        pricesWithVat.forEach(e -> System.out.printf("%.2f%n",e));
    }
}
