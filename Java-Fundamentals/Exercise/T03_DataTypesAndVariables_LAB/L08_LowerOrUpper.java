package T03_DataTypesAndVariables_LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class L08_LowerOrUpper {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        char m;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        m = (char) bf.read();

        if (m >= 97 && m <= 123) {
            System.out.println("lower-case");
        } else {
            System.out.println("upper-case");
        }

    }
}
