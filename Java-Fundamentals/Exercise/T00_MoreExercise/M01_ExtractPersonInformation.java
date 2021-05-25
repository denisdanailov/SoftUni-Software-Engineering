package T00_MoreExercise;

import java.util.Scanner;

public class M01_ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {

          String input = scanner.nextLine();
          int nameStartIndex = input.indexOf('@');
          int nameEndIndex = input.indexOf('|');

          int ageStartIndex = input.indexOf('#');
          int ageEndIndex = input.indexOf('*');

          String name = input.substring(nameStartIndex + 1,nameEndIndex);
          String age = input.substring(ageStartIndex + 1,ageEndIndex);

          System.out.println(String.format("%s is %s years old.",name,age));
        }
    }
}
