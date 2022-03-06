package HospitalDatebase.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String comments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "diagnoses_patients",
            joinColumns = {@JoinColumn(name = "diagnosis_id")},
            inverseJoinColumns = {@JoinColumn(name = "patient_id")}
    )
    private Set<Patient> diagnosedPatients;

    public Diagnose(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    public Diagnose() {
        this.diagnosedPatients = new HashSet<>();
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<Patient> getDiagnosedPatients() {
        return Collections.unmodifiableSet(diagnosedPatients);
    }

    public void setDiagnosedPatients(Set<Patient> diagnosedPatients) {
        this.diagnosedPatients = diagnosedPatients;
    }
}
