package T00_Mid_Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split("!");
        List<String> shoppingLIst = new ArrayList<>();

        for (String s : inputArr) {
            shoppingLIst.add(s);
        }

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {

            String[] commandArr = command.split(" ");
            String item = commandArr[1];
            String productCommand = commandArr[0];
            switch (productCommand) {
                case "Urgent":
                    if (!shoppingLIst.contains(item)) {
                        shoppingLIst.add(0,item);
                    }
                    break;
                case "Unnecessary":
                    if (shoppingLIst.contains(item)) {
                        shoppingLIst.remove(item);
                    }
                    break;
                case "Correct":
                    String oldItem = commandArr[1];
                    String newItem = commandArr[2];
                    if (shoppingLIst.contains(oldItem)) {
                        int index = shoppingLIst.indexOf(oldItem);
                        shoppingLIst.remove(oldItem);
                        shoppingLIst.add(index,newItem);

                    }
                    break;
                case "Rearrange":
                    if (shoppingLIst.contains(item)) {
                        shoppingLIst.remove(item);
                        shoppingLIst.add(item);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.print(shoppingLIst.toString().replaceAll("[\\[\\]]",""));

    }
}
