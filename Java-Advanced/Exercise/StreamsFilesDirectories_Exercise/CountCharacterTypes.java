package StreamsFilesDirectories_Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/input.txt");
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path);
        } catch (Exception io) {
            System.out.println("Another error with reading file");
        }
        Map<String, Integer> symbols = new HashMap<>();
        symbols.put("vowels",0);
        symbols.put("consonants",0);
        symbols.put("punctuations",0);

        for (String line : lines) {
            for(char symbol : line.toCharArray()) {
                if (symbol == ' ') {
                    continue;
                }
                if (isVowel(symbol)) {
                    symbols.put("vowels", symbols.get("vowels") + 1);
                } else if (isPunctuational(symbol)) {
                    symbols.put("punctuations",symbols.get("punctuations") + 1);
                } else {
                    symbols.put("consonants",symbols.get("consonants") +1);
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_task.4.txt"));
        writer.write("Vowels: " + symbols.get("vowels"));
        writer.newLine();
        writer.write("Consonants: " + symbols.get("consonants"));
        writer.newLine();
        writer.write("Punctuation: " + symbols.get("punctuations"));
        writer.close();

    }

    private static boolean isPunctuational(char symbol) {
        return symbol == '!' || symbol == '.' || symbol == ',' || symbol == '?';

    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}
