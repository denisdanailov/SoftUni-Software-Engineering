package Encapsulation_LAB.ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, Integer age, Double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName( String firstName) {
        if (firstName.length() < 3 ) {
            throw new IllegalArgumentException("First Name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw  new IllegalArgumentException("Last Name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public Double getSalary() {
        return this.salary;
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
