package T00_MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class M01_Encrypt_Sort_PrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countNames = Integer.parseInt(scanner.nextLine());

        int[] arraySumNames = new int[countNames];
        int sum = 0;

        for (int i = 0; i <countNames ; i++) {
            String names = scanner.nextLine();
            sum= 0;

            for (int j = 0; j < names.length(); j++) {
                char letter = names.charAt(j);

                    switch (names.charAt(j)) {
                        case 'a':
                        case 'A':
                        case 'o':
                        case 'O':
                        case 'u':
                        case 'U':
                        case 'e':
                        case 'E':
                        case 'i':
                        case 'I':
                            sum += letter * names.length();
                           break;
                        default:
                            sum += letter / names.length();
                            break;

                }
                arraySumNames[i] = sum;
            }

        }
        int[] biggestArray = new int[arraySumNames.length];
        for (int i = 0; i < arraySumNames.length ; i++) {
//
            for (int j = 0; j < biggestArray.length; j++) {
                biggestArray[i] = arraySumNames[i];
            }
        }
        Arrays.sort(arraySumNames);

        for (int i = 0; i < arraySumNames.length; i++) {
            System.out.println(arraySumNames[i]);

        }

    }
}
