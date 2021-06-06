package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources 3/input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);

        int nextByte = inputStream.read();

        while (nextByte != -1 ) {
            System.out.print(Integer.toBinaryString(nextByte) + " ");
            nextByte = inputStream.read();
        }
    }
}
