package StreamsFilesDirectories_Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumLines {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/input.txt");

        Files.readAllLines(path).forEach(line ->{
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        });

    }
}
