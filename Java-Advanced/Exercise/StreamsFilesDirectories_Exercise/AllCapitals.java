package StreamsFilesDirectories_Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/input.txt");

        List<String> lines = Files.readAllLines(path);

        BufferedWriter writer = new BufferedWriter
                (new FileWriter("output.txt"));

        for (String line : lines) {
            writer.write(line.toUpperCase(Locale.ROOT));
            writer.newLine();
        }
        writer.close();



    }
}
