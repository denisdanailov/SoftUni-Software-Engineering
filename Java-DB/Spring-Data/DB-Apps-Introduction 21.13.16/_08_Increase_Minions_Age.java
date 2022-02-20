import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class _08_Increase_Minions_Age {

    public static void main(String[] args) throws SQLException {

        Connection connection = MyConnector.getConnection();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the minions Id`s you want yo increase");

        int[] idInput = Arrays.stream(scanner.nextLine()
                .split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        PreparedStatement setId = connection.prepareStatement(
                "UPDATE minions" +
                        " SET age = age + 1" +
                        " WHERE `id`  IN (?);");

        for (int i = 0; i < idInput.length ; i++) {
            setId.setInt(1,idInput[i]);
            setId.executeUpdate();
        }

        printMinionsWithNameAndAge(connection);

    }
    public static void printMinionsWithNameAndAge(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT name, age FROM minions");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = Integer.parseInt(resultSet.getString("age"));
            System.out.printf("%s %d%n",name,age );
        }
    }
}
