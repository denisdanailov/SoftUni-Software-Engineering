package T09_Lists_LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> digits = new ArrayList<>(Arrays.asList(10, 20, 30 , 40 , 50));

        digits.remove(Integer.valueOf(50));
        digits.remove(3);

        for (int i = 0; i < digits.size(); i++) {
            System.out.println(digits.get(i));
        }
        }


    }

