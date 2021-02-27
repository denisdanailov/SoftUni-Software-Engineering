package MidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        List<String> text = new ArrayList<>();

        String[] command = scanner.nextLine().split("\\s+");

        while (!"end".equals(command[0])) {


            switch (command[0]) {

                case "Chat":
                    for (int i = 1; i < command.length; i++) {
                        text.add(command[i]);
                    }
                    break;
                case "Delete":
                    String message = command[1];
                    if (text.contains(message) ) {
                        text.remove(message);
                    }
                    break;
                case "Edit":
                    String messageToEdit = command[1];
                    String editedVersion = command[2];
                    if (text.contains(messageToEdit)) {
                       int index = text.indexOf(messageToEdit);
                        text.set(index,editedVersion);
                    }
                    break;
                case "Pin":
                    String pinMessage = command[1];
                    if (text.contains(pinMessage)) {
                        text.remove(pinMessage);
                        text.add(pinMessage);
                    }
                    break;
                case "Spam":
                    for (int i = 1; i < command.length ; i++) {
                        text.add(text.size(),command[i]);
                    }
                    break;

            }
            command = scanner.nextLine().split("\\s+");
        }
        for (String s : text) {
            System.out.println(s);
        }
    }
}
