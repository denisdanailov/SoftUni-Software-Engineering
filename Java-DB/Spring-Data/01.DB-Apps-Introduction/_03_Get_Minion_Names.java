import java.sql.*;
import java.util.Scanner;

public class _03_Get_Minion_Names {

    public static void main(String[] args) throws SQLException {

        Connection connection = MyConnector.getConnection();

        Scanner scanner = new Scanner(System.in);

        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement villainStatement = connection.prepareStatement(
                "SELECT name FROM villains WHERE id = ?;");
        villainStatement.setInt(1, villainId);

        ResultSet villainSet = villainStatement.executeQuery();

        if (!villainSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        } else  {
            String villainName = villainSet.getString("name");
            System.out.printf("Villain: %s%n",villainName );

            PreparedStatement minionStatement = connection.prepareStatement(
                    "SELECT m.`name`, m.`age` FROM `minions` AS m" +
                            " JOIN minions_villains mv on m.id = mv.minion_id" +
                            " WHERE mv.villain_id =?;");
            minionStatement.setInt(1, villainId);

            ResultSet minionSet = minionStatement.executeQuery();

            for (int minion = 1; minionSet.next() ; minion++) {

                String minionName = minionSet.getString("name");
                int minionAge = Integer.parseInt(minionSet.getString("age"));

                System.out.printf("%d. %s %d%n", minion,minionName, minionAge);
            }

        }

    }
}
