import java.sql.*;
public class _02_Get_Minion_Names {


    public static void main(String[] args)  throws SQLException  {

       Connection connection = MyConnector.getConnection();

        PreparedStatement statement = connection.prepareStatement(
                "SELECT `name`, COUNT(mv.minion_id) AS cunt_of_minions FROM villains AS v" +
                        " JOIN minions_villains AS mv on v.id = mv.villain_id" +
                        " GROUP BY mv.villain_id" +
                        " HAVING cunt_of_minions > 15" +
                        " ORDER BY cunt_of_minions DESC");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String dbUsername = resultSet.getString("name");
            int minionCount = resultSet.getInt("cunt_of_minions");

            System.out.println(dbUsername + " " + minionCount);

        }
    }
}
