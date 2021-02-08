package T00_Mid_Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("@");
        List<Integer> listOfHouses = new ArrayList<>();

        for (String s : input) {
            listOfHouses.add(Integer.parseInt(s));
        }
        int currentIndex = 0;
        String command = scanner.nextLine();
        while (!"Love!".equals(command)) {
            String[] tokens = command.split("\\s+");
            int jumpLength = Integer.parseInt(tokens[1]);
            currentIndex += jumpLength;

            if (currentIndex >= listOfHouses.size()) {
                currentIndex = 0;
            }
            if (listOfHouses.get(currentIndex) != 0) {
                listOfHouses.set(currentIndex , listOfHouses.get(currentIndex) - 2);
                if (listOfHouses.get(currentIndex) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            }
            else {
                System.out.printf("Place %d already had Valentine's day.%n",currentIndex);
            }
            command = scanner.nextLine();
        }
        listOfHouses.removeIf(house -> house == 0);
        System.out.printf("Cupid's last position was %d.%n",currentIndex);

        if (listOfHouses.size() == 0) {
            System.out.println("Mission was successful");
        } else {
            System.out.printf("Cupid has failed %d places.",listOfHouses.size());
        }
    }
}
