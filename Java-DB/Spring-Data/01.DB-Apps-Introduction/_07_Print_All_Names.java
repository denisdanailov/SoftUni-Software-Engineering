import java.sql.*;
import java.util.*;

public class _07_Print_All_Names {
    public static void main(String[] args) throws SQLException {

        Connection connection = MyConnector.getConnection();

        Scanner scanner = new Scanner(System.in);

        PreparedStatement allTowns = connection.prepareStatement("SELECT name FROM minions;");
        ResultSet resultSet = allTowns.executeQuery();

      List<String> reversedMinions = reverseTableMinions(resultSet);

        for (String minion : reversedMinions) {
            System.out.println(minion);
        }

    }

    private static List<String> reverseTableMinions(ResultSet resultSet) throws SQLException {
        List<String> minionNames = new ArrayList<>();

        for (int i = 1; resultSet.next(); i++) {
            String minionName = resultSet.getString("name");
            minionNames.add(minionName);
        }

        List<String> minionNamesLeft = new ArrayList<>();
        List<String> minionNamesRight = new ArrayList<>();

        for (int i = 0; i < minionNames.size() / 2 ; i++) {
            minionNamesLeft.add(minionNames.get(i));
        }

        for (int i = minionNames.size() / 2; i < minionNames.size() ; i++) {
            minionNamesRight.add(minionNames.get(i));
        }

        Collections.reverse(minionNamesRight);

        List<String> reversedList = new ArrayList<>();

        for (int i = 0; i < minionNames.size() / 2; i++) {
            reversedList.add(minionNamesLeft.get(i));
            reversedList.add(minionNamesRight.get(i));
        }

        return reversedList;
    }
}
