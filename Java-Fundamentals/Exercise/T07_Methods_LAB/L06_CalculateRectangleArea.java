package T07_Methods_LAB;

import java.util.Scanner;

public class L06_CalculateRectangleArea {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int area = calculateArea(width, height);

        System.out.println(area);

    }

    private static int calculateArea(int a, int b) {
        return a * b;
    }
}
