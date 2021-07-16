package Encapsulation_LAB.SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, Integer age, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
    public Double getSalary() {
        return this.salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void increaseSalary(Double bonus) {
        if (this.age > 30) {
            this.salary = this.salary + this.salary * (bonus / 100);
        } else {
            this.salary = this.salary + this.salary * bonus / 200;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.3f leva",
                this.getFirstName(), this.getLastName(), this.getSalary());
    }
}
