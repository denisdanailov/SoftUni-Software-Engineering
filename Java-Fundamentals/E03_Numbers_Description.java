package T00_Mid_Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E03_Numbers_Description {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");

        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i <inputArr.length ; i++) {
            numbersList.add(Integer.parseInt(inputArr[i]));
        }

        double averageNumber = 0;

        for (int i = 0; i < numbersList.size(); i++) {
            averageNumber+= numbersList.get(i);
        }

       List<Integer> top5Numbers = new ArrayList<>();
        Collections.sort(numbersList);
        Collections.reverse(numbersList);

        if (numbersList.size() < 5 ) {
            System.out.println("No");
        } else {

            for (int i = 0; i < 5 ; i++) {

                if (numbersList.get(i) > averageNumber / numbersList.size()) {
                    top5Numbers.add(numbersList.get(i));
                }
            }
        }

        System.out.print(top5Numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
