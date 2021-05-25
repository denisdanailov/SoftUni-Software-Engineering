package T10_Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestsList = new ArrayList<>();
        int countGuests = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countGuests ; i++) {

            String tokens[] = scanner.nextLine().split(" ",2);
            String name = tokens[0];
            if ("is going!".equals(tokens[1])) {
                    if (guestsList.contains(name)) {
                        System.out.printf("%s is already in the list!%n", name);
                    } else {
                        guestsList.add(name);
                    }
            } else if ("is not going!".equals(tokens[1])) {
                    if (guestsList.contains(name)) {
                        guestsList.remove(name);
                    } else {
                        System.out.printf("%s is not in the list!%n", name);
                    }
            }
        }
        for (int i = 0; i <guestsList.size() ; i++) {
            System.out.println(guestsList.get(i));
        }
    }
}
