package T14_MapsLambdaStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02_MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> elements = new LinkedHashMap<>();
        String item = scanner.nextLine();
        while (!"stop".equals(item)) {
            int count = Integer.parseInt(scanner.nextLine());
            elements.putIfAbsent(item,0);
            int newCount = elements.get(item) + count;
            elements.put(item,newCount);

            item = scanner.nextLine();
        }
        elements
                .entrySet()
                .stream()
                .forEach(e -> System.out.println(String.format("%s -> %d",e.getKey(),e.getValue())));
    }
}
