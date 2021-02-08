package T00_Mid_Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");

        List<String> collectionTokens = new ArrayList<>();

        for (String collectionToken : tokens) {
            collectionTokens.add(collectionToken);
        }
        String command = scanner.nextLine();
        while (!"Craft!".equals(command)) {


            String inputReplace = command.replaceAll("-", "");
            String inputMinus = inputReplace.replaceAll(":"," ");
            String[] inputArr = inputMinus.split("\\s+");

            String itemCommand = inputArr[0];
            String item = inputArr[1];

            switch (itemCommand) {
                case "Collect":
                    if (!collectionTokens.contains(item)) {
                        collectionTokens.add(item);
                    } else {
                        continue;
                    }
                    break;
                case "Drop":
                    if (collectionTokens.contains(item)) {
                        collectionTokens.remove(item);

                    }
                    break;
                case "Combine":
                        String itemOld = inputArr[2];
                        String itemNew = inputArr[3];
                        if (collectionTokens.contains(itemOld)) {
                            collectionTokens.add(itemNew);
                        }
                    break;
                case "Renew":
                    collectionTokens.remove(item);
                    collectionTokens.add(item);
                    break;
            }



            command = scanner.nextLine();
        }

        System.out.print(collectionTokens.toString().replaceAll("[\\[\\]]",""));
    }
}
