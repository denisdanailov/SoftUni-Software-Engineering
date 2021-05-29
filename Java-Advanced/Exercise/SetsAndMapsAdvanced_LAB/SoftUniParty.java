package SetsAndMapsAdvanced_LAB;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipGuests = new HashSet<>();
        Set<String> regularGuests = new HashSet<>();

        String guests = scanner.nextLine();
        while (!"PARTY".equals(guests)) {
            if (guests.length() == 8) {
                if (Character.isDigit(guests.charAt(0))) {
                    vipGuests.add(guests);
                } else {
                    regularGuests.add(guests);
                }
            }
            guests = scanner.nextLine();
        }
        String output = scanner.nextLine();
        while (!"END".equals(output)) {
            if (Character.isDigit(output.charAt(0))) {
                if (vipGuests.contains(output)) {
                    vipGuests.remove(output);
                }
            } else if (regularGuests.contains(output)) {
                regularGuests.remove(output);
            }
            output = scanner.nextLine();
        }
        System.out.println(vipGuests.size() + regularGuests.size());
        if (!vipGuests.isEmpty()) {
            vipGuests.forEach(System.out::println);
        }
        if (!regularGuests.isEmpty()) {
            regularGuests.forEach(System.out::println);
        }


    }
}
