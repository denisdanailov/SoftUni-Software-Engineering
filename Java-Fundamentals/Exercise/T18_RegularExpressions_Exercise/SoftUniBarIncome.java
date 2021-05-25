package T18_RegularExpressions_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String regex = "%(?<name>[A-Z][a-z]+)%([^\\|\\$\\%\\.]+)?\\<(?<product>\\w+)\\>([^\\|\\$\\%\\.]+)?\\|(?<count>\\d+)\\|([^\\|\\$\\%\\.\\d]+)?(?<price>\\d+(\\.\\d+)?)\\$";
        Pattern pattern = Pattern.compile(regex);



        double sum = 0;
        String input = scanner.nextLine();
        while (!"end of shift".equals(input)) {

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                double count = Double.parseDouble(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double result = count * price;

                System.out.println(String.format("%s: %s - %.2f",name,product,result));
                sum+= result;

            }

            input = scanner.nextLine();
        }
        System.out.println(String.format("Total income: %.2f",sum));


    }
}
