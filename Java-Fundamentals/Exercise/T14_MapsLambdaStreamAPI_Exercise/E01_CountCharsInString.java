package T14_MapsLambdaStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01_CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wort = scanner.nextLine();
        Map<String,Integer> occurrences = new LinkedHashMap<>();

        String[] wortArr = wort.split("|");

        for (int i = 0; i < wortArr.length ; i++) {
            String token = wortArr[i];


            if (!occurrences.containsKey(token)) {
                occurrences.put(token,1);
            } else {
                int newQuantity = occurrences.get(token) + 1;
                occurrences.put(token,newQuantity);
            }
        }
        if (occurrences.containsKey(" ")) {
            occurrences.remove(" ");
        }
        occurrences.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
