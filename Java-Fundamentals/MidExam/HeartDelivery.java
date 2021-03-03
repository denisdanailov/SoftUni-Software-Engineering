package MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("@");
        List<Integer> houses = new ArrayList<>();

        for (String s : input) {
            houses.add(Integer.parseInt(s));
        }
        String jump = scanner.nextLine();
        int current = 0;
        int places = houses.size();
        while (!"Love!".equals(jump)) {
            int index = Integer.parseInt(jump.split(" ")[1]);
            if (index + current > houses.size() -1) {
                current = 0;
                index = 0;
            }
            current += index;
            if (houses.get(current) == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", current);
            } else {

                houses.set(current, houses.get(current) - 2);

                if (houses.get(current) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", current);
                    places-= 1;
                }
            }
            jump = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n",current);
        if (places == 0) {
            System.out.printf("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.",places);
        }
    }
}
