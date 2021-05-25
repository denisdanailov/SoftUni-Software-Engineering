package T08_MEthods_Exercise;

import java.util.Scanner;

public class E02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

         vowelsOfName(name);
    }

    public static int vowelsOfName (String name ) {
        int vowels = 0;
        for (int i = 0; i < name.length(); i++) {

           char charName = name.charAt(i);

           switch (charName) {
               case 'a':
               case 'A':
               case 'o':
               case 'O':
               case 'u':
               case 'U':
               case 'i':
               case 'I':
               case 'e':
               case 'E':
                   vowels++;
                   break;

           }

        }
        System.out.println(vowels);
        return vowels;
    }
}
