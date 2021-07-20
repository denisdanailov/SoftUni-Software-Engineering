package InterfacesAndAbstraction_Exercise.MultipleImplementation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyersByNames = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Buyer buyer = createBuyer(scanner.nextLine());
            buyersByNames.put(buyer.getName(), buyer);
        }

        String names = scanner.nextLine();
        while (!names.equals("End")) {
            Buyer buyer = buyersByNames.get(names);

            if (buyer != null) {
                buyer.buyFood();
            }

            names = scanner.nextLine();
        }

    }

    private static Buyer createBuyer(String input) {
        String[] data = input.split("'\\+");
        if (data.length == 4) {
            return new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]);
        }
        return new Rebel(data[0], Integer.parseInt(data[1]),data[2]);

    }
}
