package T00_MoreExercise;

import java.util.Scanner;

public class M02_FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                char leftElement = input.charAt(j);
                if (leftElement != 32) {
                    if (leftElement == '-') {
                        leftElement = input.charAt(j + 1);
                        j++;
                        left -= Integer.parseInt(String.valueOf(leftElement));
                    } else {
                        left += Integer.parseInt(String.valueOf(leftElement));
                    }
                }
                if (leftElement == 32) {
                    j++;
                    for (int k = j; j <= input.length() - 1; j++) {
                        char rightElement = input.charAt(j);
                        if (rightElement == '-') {
                            rightElement = input.charAt(j + 1);
                            j++;
                            right -= Integer.parseInt(String.valueOf(rightElement));
                        } else {
                            right += Integer.parseInt(String.valueOf(rightElement));
                        }
                    }
                }
            }

            if (left > right) {
                System.out.println(left);
            } else {
                System.out.println(right);
            }
            left = 0;
            right = 0;
        }

    }
}
