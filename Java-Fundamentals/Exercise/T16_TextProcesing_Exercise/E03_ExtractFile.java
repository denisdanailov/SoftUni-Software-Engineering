package T16_TextProcesing_Exercise;

import java.util.Scanner;

public class E03_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        int slashIndex = path.lastIndexOf('\\');
        int pointIndex = path.lastIndexOf('.');

        String fileName = path.substring(slashIndex + 1,pointIndex);
        String extension = path.substring(pointIndex + 1);

        System.out.println(String.format("File name: %s",fileName));
        System.out.println(String.format("File extension: %s",extension));

    }
}
