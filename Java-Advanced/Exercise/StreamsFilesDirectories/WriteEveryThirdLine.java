package StreamsFilesDirectories;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources 3/input.txt";

        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);

        PrintStream printStream = new PrintStream("output-third-line.txt");

        int lineNumber = 0;

        while (scanner.hasNext()) {
            lineNumber++;
            if (lineNumber % 3 == 0) {
                printStream.println(scanner.nextLine());

            } else {
                scanner.nextLine();
            }
        }
    }
}
