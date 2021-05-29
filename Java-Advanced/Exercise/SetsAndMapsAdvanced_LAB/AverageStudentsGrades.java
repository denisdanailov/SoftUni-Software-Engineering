package SetsAndMapsAdvanced_LAB;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfStudents = Integer.parseInt(scanner.nextLine());
        HashMap<String, List<Double>> studentsWhitGrade = new HashMap<>();

        for (int i = 0; i < countOfStudents ; i++) {
            String[] studentAndGrade = scanner.nextLine().split("\\s+");
            String student = studentAndGrade[0];
            double grade = Double.parseDouble(studentAndGrade[1]);



            if (!studentsWhitGrade.containsKey(student)) {
                studentsWhitGrade.put(student, new ArrayList<>());
            }
            studentsWhitGrade.get(student).add(grade);
        }

        studentsWhitGrade.entrySet()
                .forEach(entry -> {
                    double average = entry.getValue()
                            .stream()
                            .mapToDouble(e -> e)
                            .average().getAsDouble();

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n",average);
                });

//        for (var student : studentsWhitGrade.entrySet()) {
//
//            System.out.print(student.getKey() + " -> ");
//            System.out.println(student.getValue().toString().replaceAll("[\\[\\]]",""));
//        }
    }
}
