package FinalExamPreparation;

import java.util.Scanner;

public class ImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder massage = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Decode".equals(input)) {

            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Move":

                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    String cutMessage = massage.substring(0,numberOfLetters);
                   massage.delete(0,numberOfLetters);
                   massage.append(cutMessage);

                    break;

                case "Insert":

                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    massage.insert(index ,value);
                    break;

                case "ChangeAll":

                    String substring = tokens[1];
                    String replacement = tokens[2];
                    massage = new StringBuilder(massage.toString().replace(substring,replacement));

                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.format("The decrypted message is: %s",massage.toString()));
    }
}
