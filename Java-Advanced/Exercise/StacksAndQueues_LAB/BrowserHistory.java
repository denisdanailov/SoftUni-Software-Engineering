package StacksAndQueues_LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String command = scanner.nextLine();
        String currentURL = null;

        while (!command.equals("Home")) {

            if (command.equals("back")) {

                if (browserHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    currentURL = browserHistory.pop();
                }
            } else {
                if (currentURL != null) {
                    browserHistory.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);

            command = scanner.nextLine();
        }

    }
}
