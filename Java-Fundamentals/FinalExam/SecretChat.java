package FinalExamPreparation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String massage = scanner.nextLine();
        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append(massage);

        while (!"Reveal".equals(input)) {

            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    String space = " ";
                    sb.delete(0,sb.length());
                    sb.append(massage);
                    if (index < sb.length() && index >= 0 ) {
                        sb.insert(index,space);
                        massage = sb.toString();
                        System.out.println(massage);
                    }
                    break;
                case "Reverse":
                    String substring = tokens[1];

                    if (massage.contains(substring)) {
                        String forReplays = new StringBuilder(substring).reverse().toString();
                        massage = massage.replaceFirst(Pattern.quote(substring),"") + forReplays;
                        System.out.println(massage);

                    } else {
                        System.out.println("error");
                    }

                    break;
                case "ChangeAll":
                    String subs = tokens[1];
                    String replacement = tokens[2];
                    massage = massage.replaceAll(subs,replacement);
                    System.out.println(massage);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.format("You have a new text message: %s",massage));
    }
}
