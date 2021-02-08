package T00_Mid_Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E03_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Integer> shootingList = new ArrayList<>();

        for (String s : input) {
            shootingList.add(Integer.parseInt(s));
        }
        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String[] tokens = command.split(" ");
            int index = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);

            switch (tokens[0]) {
                case "Shoot":
                    if (shootingList.size() >= index) {
                        shootingList.set(index,shootingList.get(index)- power);

                        if (shootingList.get(index) <= 0) {
                            shootingList.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (shootingList.size() >= index) {
                        shootingList.add(index,power);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (index - power <= shootingList.size() - 1 && index + power <= shootingList.size() - 1) {
                        for (int i = 0; i < shootingList.size() / 2 ; i++) {
                            shootingList.remove(index+i);
                            shootingList.remove(index-i);
                        }
                        shootingList.remove(index - 1);
                    } else {
                        System.out.println("Strike missed!");
                    }

                    break;
            }

            command = scanner.nextLine();
        }
       String output = shootingList.toString().replaceAll("[\\[\\],]","");
        System.out.println(output.replaceAll(" ", "|"));

    }
}
