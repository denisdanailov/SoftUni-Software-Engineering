package FinalExam;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class Problem3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> usersList = new TreeMap<>();

        int countUsers = 0;
        String input = scanner.nextLine();
        while (!"Statistics".equals(input)) {

            String[] tokens = input.split("->");
            String command = tokens[0];
            String username = tokens[1];


            switch (command) {

                case "Add":
                    if (!usersList.containsKey(username)) {
                        usersList.put(username,new ArrayList<>());
                        countUsers++;
                    } else {
                        System.out.println(String.format("%s is already registered",username));
                    }
                    break;
                case "Send":
                    String email = tokens[2];
                    usersList.get(username).add(email);
                    break;
                case "Delete":
                    if (usersList.containsKey(username)) {
                        usersList.remove(username);
                        countUsers--;
                    } else
                        System.out.println(String.format("%s not found!",username));
                    break;
            }

            input = scanner.nextLine();
        }
        Map<String, List<String>> sorted = usersList.entrySet().stream()
    .sorted(comparingInt(e -> e.getValue().size()))
    .collect(toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (a, b) -> { throw new AssertionError(); },
        LinkedHashMap::new
    ));

        System.out.println(String.format("Users count: %d",countUsers));

        for (Map.Entry<String, List<String>> users  : sorted.entrySet()) {
            System.out.println(String.format("%s",users.getKey()));
            for (int i = 0; i < users.getValue().size() ; i++) {
                System.out.println(" - "+ users.getValue().get(i));
            }
        }

    }
}
