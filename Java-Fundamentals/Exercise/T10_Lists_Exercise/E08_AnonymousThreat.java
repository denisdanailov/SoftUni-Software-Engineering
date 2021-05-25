package T10_Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E08_AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split(" ");
        List<String> elements = new ArrayList<>();

        for (String token : sequence) {
            elements.add(token);
        }
        String input = scanner.nextLine();

        while (!"3:1".equals(input)) {

            String[] tokens = input.split(" ");

            String command = tokens[0];
            int startIndex = Integer.parseInt(tokens[1]);
            int endIndex = Integer.parseInt(tokens[2]);

            if (startIndex < 0) {
                startIndex= 0;
            }
            if ( endIndex > elements.size()) {
                endIndex = elements.size() - 1;
            }

            switch (command) {
                case "merge":
                    toMerge(elements,startIndex,endIndex);
                    break;
                case "divide":
                    toDivide(elements,startIndex,endIndex);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(elements.toString().replaceAll("[\\[\\],]",""));
    }

    private static void toMerge(List<String> elements, int startIndex, int endIndex) {

        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex ; i++) {
            sb.append(elements.get(i));
//                        elements.remove(i);
        }
        for (int i = endIndex; i >= startIndex ; i--) {
            elements.remove(elements.get(i));
        }
        elements.add(startIndex,sb.toString());
    }

    private static void toDivide(List<String> elements, int startIndex, int endIndex) {

        StringBuilder stringBuilder = new StringBuilder();
       int current = elements.get(startIndex).length() / endIndex;
       stringBuilder.append(elements.get(startIndex));
       elements.remove(startIndex);

       int currentLength = elements.size() + endIndex;

        for (int i = startIndex; i <= currentLength - 1; i++) {
            elements.add(stringBuilder.substring(0,current));
            stringBuilder.delete(0,current);
        }
    }
}
