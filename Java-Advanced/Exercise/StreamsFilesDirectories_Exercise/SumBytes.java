package StreamsFilesDirectories_Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/input.txt");
        List<String> lines = Files.readAllLines(path);


        int sumLines = 0;
        for (String line : lines) {
            sumLines += getSumAsciiLine(line);
        }
        System.out.println(sumLines);
    }

    private static int getSumAsciiLine(String line) {
        int sum = 0;
        for (char symbol : line.toCharArray()) {
            sum += symbol;
        }
        return sum;
    }
}
