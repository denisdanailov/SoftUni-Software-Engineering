package T14_MapsLambdaStreamAPI_Exercise;

import java.util.*;

public class E06_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            courses.putIfAbsent(courseName,new ArrayList<>());
            courses.get(courseName).add(studentName);


            input = scanner.nextLine();
        }
        courses
                .entrySet()
                .stream()
                .sorted((c1,c2) -> Integer.compare(c2.getValue().size(),c1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d",entry.getKey(),entry.getValue().size()));
                    entry
                            .getValue()
                            .stream()
                            .sorted()
                            .forEach(s -> System.out.println(String.format("-- %s", s)));
                        });
    }
}
