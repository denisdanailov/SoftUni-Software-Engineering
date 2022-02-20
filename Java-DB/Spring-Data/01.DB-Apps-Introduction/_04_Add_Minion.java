import java.sql.*;
import java.util.Scanner;

public class _04_Add_Minion {

    public static void main(String[] args) throws SQLException {

        Connection connection = MyConnector.getConnection();

        Scanner scanner = new Scanner(System.in);

        String[] minionInfo = scanner.nextLine().split("\\s+");
        String villainName = scanner.nextLine().split("\\s+")[1];

        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];


       int townId = getOrInsertTown(connection, minionTown);
       int villainId = getOrInsertVillain(connection, villainName);

       PreparedStatement insertMinion = connection.prepareStatement("" +
               "INSERT INTO minions(name,age,town_id) VALUES(?, ?, ?)");
       insertMinion.setString(1,minionName);
       insertMinion.setInt(2, minionAge);
       insertMinion.setInt(3,townId);
       insertMinion.executeUpdate();

       PreparedStatement getLastMinion = connection.prepareStatement(
               "SELECT id FROM minions ORDER BY id DESC");
       ResultSet lastMinionSet = getLastMinion.executeQuery();

       lastMinionSet.next();
        int lastMinionId = lastMinionSet.getInt("id");

       PreparedStatement insertMinionsVillains = connection.prepareStatement("" +
               "INSERT INTO minions_villains VALUES  (?, ?)");
       insertMinionsVillains.setInt(1, lastMinionId);
       insertMinionsVillains.setInt(2, villainId);
       insertMinionsVillains.executeUpdate();

       System.out.printf("Successfully added %s to be minion of %s%n", minionName, villainName);

    }

    private static int getOrInsertVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement selectVillain = connection.prepareStatement("" +
                "SELECT id FROM villains WHERE name = ?");
        selectVillain.setString(1, villainName);

        ResultSet villainSet = selectVillain.executeQuery();

        int villainId = 0;
        if (!villainSet.next()) {
            PreparedStatement insertVillain = connection.prepareStatement(
                    "INSERT INTO villains(name, evilness_factor) VALUES(?, ?);");
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");

            insertVillain.executeUpdate();

            ResultSet newVillainSet = selectVillain.executeQuery();
            newVillainSet.next();
            villainId = newVillainSet.getInt("id");
            System.out.printf("Villain %s was added to the database%n", villainName);
        } else {
            villainId = villainSet.getInt("id");
        }

        return villainId;
    }

    private static int getOrInsertTown(Connection connection, String minionTown) throws SQLException {
        PreparedStatement selectTown = connection.prepareStatement("" +
                "SELECT id FROM towns WHERE name = ?");
        selectTown.setString(1, minionTown);

        ResultSet townSet = selectTown.executeQuery();

        int townId = 0;
        if (!townSet.next()) {
            PreparedStatement insertTown = connection.prepareStatement(
                    "INSERT INTO towns(name) VALUES  (?);");
                insertTown.setString(1, minionTown);
                insertTown.executeUpdate();

                ResultSet newTownSet = selectTown.executeQuery();
                newTownSet.next();
                townId = newTownSet.getInt("id");

        } else {
            townId = townSet.getInt("id");
        }

        return townId;
    }
}
