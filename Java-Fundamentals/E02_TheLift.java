package T00_Mid_Exam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPeople = Integer.parseInt(scanner.nextLine());
        String[] countWaggons = scanner.nextLine().split(" ");

        List<Integer> waggons = new ArrayList<>();

        for (String s : countWaggons) {
            waggons.add(Integer.parseInt(s));
        }

        for (int i = 0; i < waggons.size() ; i++) {
            if (waggons.get(i) >= 0) {
                countOfPeople+= waggons.get(i);
                waggons.remove(i);
                waggons.add(i,0);
            }
            if (countOfPeople < 4 ) {
                waggons.remove(i);
                waggons.add(i,countOfPeople);
                countOfPeople=0;
            }
            if (countOfPeople >= 4) {
                waggons.remove(i);
                waggons.add(i,4);
                countOfPeople-= 4;
            }
        }
        if (countOfPeople <= 0 ) {
            System.out.println("The lift has empty spots!");
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!%n",countOfPeople);
        }
        System.out.print(waggons.toString().replaceAll("[\\[\\],]",""));
    }
}
