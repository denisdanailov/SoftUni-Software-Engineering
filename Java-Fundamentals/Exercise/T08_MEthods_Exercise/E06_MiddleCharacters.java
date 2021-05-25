package T08_MEthods_Exercise;

import java.util.Scanner;

public class E06_MiddleCharacters {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        middleCharacter(input);
    }
    public static char middleCharacter (String input) {

        char character1 = ' ';
        char character2 = ' ';
        if (input.length() % 2 == 0) {
            character1 = input.charAt(input.length() / 2 - 1);
            character2 = input.charAt(input.length() / 2 );
        } else {
            character1 = input.charAt((input.length() + 1) / 2 - 1);
        }
        System.out.print(character1);
        System.out.print(character2);
        return character1;
    }
}
