import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class _05_Change_Town_Name {
    public static void main(String[] args) throws SQLException {

        Connection connection = MyConnector.getConnection();

        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        PreparedStatement setTowns = connection.prepareStatement(
                "UPDATE towns " +
                "SET `name` = upper(`name`)" +
                "WHERE `country` = ?;");
        setTowns.setString(1,country);
        int updatedTowns = setTowns.executeUpdate();
        if (updatedTowns > 0) {

        System.out.printf("%d town names were affected.%n", updatedTowns);
        PreparedStatement selectTowns = connection.prepareStatement(
                    "SELECT name FROM towns " +
                            "WHERE `country` = ?;");
            selectTowns.setString(1,country);

            ResultSet resultSet = selectTowns.executeQuery();
            List<String> towns = new ArrayList<>();
            while (resultSet.next()) {
                String town = resultSet.getString("name");
                towns.add(town);
            }
            System.out.println(String.join(", ", towns));
        } else {
            System.out.println("No town names were affected.");
        }
    }
}
