package StreamsFilesDirectories_Exercise;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {

        String path = "/Users/denisdanailov/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources 3/Exercises Resources";
        File folder = new File(path);

        int folderSize = 0;
        for(File file : folder.listFiles()) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);

    }
}
