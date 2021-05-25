package T00_MoreExercise;

import java.util.Scanner;

public class M05_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();
        String comment = scanner.nextLine();

        System.out.println("<h1>");
        System.out.println(title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println(content);
        System.out.println("</article>");
        while (!"end of comments".equals(comment)) {
            System.out.println("<div>");
            System.out.println(comment);
            System.out.println("</div>");

            comment = scanner.nextLine();
        }
    }
}
