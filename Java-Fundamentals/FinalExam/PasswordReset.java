package FinalExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"Done".equals(input)) {

            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "TakeOdd":
                 password = takeOdd(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                  password = cutPassword(password,index,length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];

                    if (password.contains(substring)) {
                        password = password.replace(substring,substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Your password is: "+ password);

    }



    private static String cutPassword(String password, int index, int length) {

        StringBuilder newPassword = new StringBuilder();
        newPassword.append(password);


       newPassword.replace(index ,(index + length) , "");

        return newPassword.toString();
    }

    private static String takeOdd(String password) {
        StringBuilder newPassword = new StringBuilder();

        for (int i = 1; i <= password.length() -1 ; i += 2) {

            newPassword.append(password.charAt(i));

        }
        return newPassword.toString();
    }

}
