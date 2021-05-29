package StacksAndQueues_LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerFiles = new ArrayDeque<>();
        String command = scanner.nextLine();


        while (!"print".equals(command)) {

            if (command.equals("cancel")) {
                String fileName = printerFiles.poll();
                if (fileName != null) {
                    System.out.println("Canceled " + fileName);
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerFiles.offer(command);
            }

            command = scanner.nextLine();
        }
        for (String file : printerFiles) {
            System.out.println(file);
        }
    }
}
