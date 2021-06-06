package StreamsFilesDirectories_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path inputOne = Path.of("/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/inputOne.txt");
        Path inputTwo = Path.of( "/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/inputTwo.txt");
        String outputFile = "/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/output.txt";
        PrintWriter writer = new PrintWriter(outputFile);


        List<String> one = Files.readAllLines(inputOne);
        List<String> two = Files.readAllLines(inputTwo);

        for (String symbol : one) {
            writer.println(symbol);
        }
        for (String symbol : two) {
            writer.println(symbol);
        }
        writer.close();


    }
}
