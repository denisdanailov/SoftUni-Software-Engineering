package T14_MapsLambdaStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05_SoftUni_Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> register = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String user = input[1];

            if (command.equals("unregister")) {
                if (!register.containsKey(user)) {
                    System.out.printf("ERROR: user %s not found%n", user);
                } else {
                    register.remove(user);
                    System.out.printf("%s unregistered successfully%n", user);
                }
            } else {
                String license = input[2];
                if ("register".equals(command)) {
                    if (register.containsKey(user)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", license);

                    } else {
                        register.putIfAbsent(user, license);
                        System.out.printf("%s registered %s successfully%n", user, license);
                    }
                }
            }
        }
        register.forEach((k, v) -> System.out.println(String.format("%s => %s", k, v)));
    }
}
