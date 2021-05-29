package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < countCommands ; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];

            switch (command) {
                case "1":
                    stack.push(text.toString());
                    String currentText = commands[1];
                    text.append(currentText);
                    break;
                case "2":
                    stack.push(text.toString());
                    int count = Integer.parseInt(commands[1]);
                    int remove = Math.abs(count - text.length());
                    text.replace(remove,text.length(), "");
                    break;
                case "3":
                    int index = Integer.parseInt(commands[1]);
                    System.out.println(text.charAt(index -1));
                    break;
                case "4":
                    text.delete(0,text.length());
                    text.append(stack.pop());
                    break;
            }
        }
    }
}
