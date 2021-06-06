package StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {


        Path inPath = Paths.get("/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources 3/Files-and-Streams/input.txt");
        Path outPath = Paths.get("/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources 3/Files-and-Streams/output.txt");

        List<String> lines = Files.readAllLines(inPath);

        Collections.sort(lines);
        List<String> sortedLines = lines.stream().sorted(String::compareTo).collect(Collectors.toList());
        Files.write(outPath, sortedLines);



    }
}
