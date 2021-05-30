package WorkingWithAbstraction_LAB.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public  Map<String,HashMap<Integer,Double>> createStudent(String name, int age, double grade) {
        HashMap<String, HashMap<Integer,Double>> students = new HashMap<>();
        this.name = name;
        this.age = age;
        this.grade = grade;

        return students;
    }

}

