package StreamsFilesDirectories_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class WordCount {
    public static void main(String[] args) throws IOException {

        String inputFile = "/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/words.txt";
        String wordsFile = "/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/text.txt";
        String outputFile = "/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/output.txt";

        BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFile));
        BufferedReader inputWordsFile = new BufferedReader(new FileReader(wordsFile));
        PrintWriter writer = new PrintWriter(outputFile);

        Map<String, Integer> wordsData = new TreeMap<>();

        addWords(inputFileReader, wordsData);
        checkWords(inputWordsFile, wordsData);
        printWords(writer, wordsData);

    }

    private static void printWords(PrintWriter writer, Map<String, Integer> wordsData) {
        wordsData.entrySet()
                .stream()
                .sorted((x,y) -> Integer.compare(y.getValue(), x.getValue()))
                .forEach( wordData ->
                   writer.printf("%s - %d%n", wordData.getKey(), wordData.getValue()));
        writer.close();
    }

    private static void checkWords(BufferedReader inputWordsFile, Map<String, Integer> wordsData) throws IOException {
        String[] text = inputWordsFile.readLine().split("\\s+");
        for (String word : text) {
            if (wordsData.containsKey(word)) {
                wordsData.put(word, wordsData.get(word) + 1);
            }
        }
    }

    private static void addWords(BufferedReader inputFileReader, Map<String, Integer> wordsData) throws IOException {
        String[] words = inputFileReader.readLine().split("\\s+");
        for (String word : words) {
         wordsData.putIfAbsent(word,0);
        }
    }
}
