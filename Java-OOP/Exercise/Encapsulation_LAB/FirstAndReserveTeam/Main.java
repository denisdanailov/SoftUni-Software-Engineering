package Encapsulation_LAB.FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlayers = Integer.parseInt(scanner.nextLine());
        List<Person> players = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers ; i++) {
            String[] player = scanner.nextLine().split("\\s+");
            Person person = new Person(player[0],player[1],Integer.parseInt(player[2]));
            players.add(person);
        }

        Team team = new Team("Black Eagles");
        for(Person player : players) {
            team.addPlayer(player);
        }

        System.out.println("First team have " +team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " +team.getReserveTeam().size() + " players");


    }
}
