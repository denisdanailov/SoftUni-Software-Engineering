package T09_Lists_LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L03_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      List<Integer> listOne = new ArrayList<>();
      List<Integer> listTwo = new ArrayList<>();

    String[] inputOne = scanner.nextLine().split(" ");

    String[] inputTwo = scanner.nextLine().split(" ");

        for (String s : inputOne) {
            listOne.add(Integer.parseInt(s));
        }
        for (String s : inputTwo) {
            listTwo.add(Integer.parseInt(s));
        }

        List<Integer> newList = new ArrayList<>();

            int i = 0;
            while (listOne.size() + listTwo.size() > i ) {

                if (listOne.size() > i) {
                    newList.add(Integer.parseInt(inputOne[i]));
                }
                if (listTwo.size() > i) {
                    newList.add(Integer.parseInt(inputTwo[i]));
                }

                    i++;
            }

        System.out.print(newList.toString().replaceAll("[\\[\\],]",""));
    }
}
