package T14_MapsLambdaStreamAPI_Exercise;

import java.util.*;

public class E08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyList = new TreeMap<>();

        String command = scanner.nextLine();
        while (!"End".equals(command)) {

            String[] tokens = command.split("->");
            String company = tokens[0];
            String employee = tokens[1];

            if (!companyList.containsKey(company)) {
                companyList.put(company,new ArrayList<>());
            }
            if (companyList.containsKey(company) && !companyList.get(company).contains(employee)) {
                companyList.get(company).add(employee);
            }

            command = scanner.nextLine();
        }

        for (var entry : companyList.entrySet()) {
            System.out.println(entry.getKey());
            for (String value : entry.getValue()) {
                System.out.println("--" + value);
            }
        }

    }
}
