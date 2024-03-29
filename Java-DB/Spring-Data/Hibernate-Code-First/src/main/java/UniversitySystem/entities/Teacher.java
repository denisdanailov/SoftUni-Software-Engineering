package UniversitySystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "teachers")
public class Teacher extends Person {

    @Column(name = "email" ,nullable = false, unique = true)
    private String email;

    @Column(name = "salary_per_hour", nullable = false)
    private float salaryPerHour;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;


    public Teacher(String firstName, String lastName, int phoneNumber, String email, float salaryPerHour) {
        super(firstName, lastName, phoneNumber);

        this.email = email;
        this.salaryPerHour = salaryPerHour;
    }

    public Teacher() {
       super();
    }
}
