package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream; 

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources 3/input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("out-copy.txt");

        while (nextByte != -1) {
            if (nextByte == ' ' || nextByte == '\r' || nextByte == '\n') {
                printStream.print((char)nextByte);
            } else {
                printStream.print(nextByte);
            }
            nextByte = inputStream.read();
        }



    }
}
