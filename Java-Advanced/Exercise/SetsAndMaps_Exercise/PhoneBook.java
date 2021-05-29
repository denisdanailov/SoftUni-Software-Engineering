package SetsAndMaps_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new TreeMap<>();
        String input;
        while (!"search".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phonebook.putIfAbsent(name,number);
        }
        String name;
        while (!"stop".equals(name = scanner.nextLine())) {
            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n",name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n",name);
            }
        }

    }
}
