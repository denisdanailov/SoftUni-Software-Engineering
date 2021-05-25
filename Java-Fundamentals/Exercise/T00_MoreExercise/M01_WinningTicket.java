package T00_MoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M01_WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "[\\W]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);


    }
}
