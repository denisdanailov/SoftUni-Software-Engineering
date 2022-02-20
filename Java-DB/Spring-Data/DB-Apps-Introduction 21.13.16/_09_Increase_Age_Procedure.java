import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class _09_Increase_Age_Procedure {
    public static void main(String[] args) throws SQLException {

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "starwars2005");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the minion ID you want yo increase");
        int inputId = Integer.parseInt(scanner.nextLine());

        PreparedStatement statement = connection.prepareStatement(
                "CALL usp_get_older(?);");

        statement.setInt(1,inputId);

        _08_Increase_Minions_Age.printMinionsWithNameAndAge(connection);

    }
}



