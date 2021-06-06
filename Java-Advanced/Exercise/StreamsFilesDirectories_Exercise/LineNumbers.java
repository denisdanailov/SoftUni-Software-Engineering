package StreamsFilesDirectories_Exercise;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/inputLineNumbers.txt");

        List<String> lines = Files.readAllLines(path);

        BufferedWriter writer = new BufferedWriter
                (new FileWriter("output.txt"));

        int counter = 1;
        for (String line : lines) {
            writer.write(counter +". " + line);
            counter++;
            writer.newLine();
        }
        writer.close();

    }
}
