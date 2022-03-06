package HospitalDatebase.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medicaments")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medicaments_patients",
            joinColumns = {@JoinColumn(name = "medicament_id")},
            inverseJoinColumns = {@JoinColumn(name = "patient_id")}
    )
    private Set<Patient> prescribedPatients;

    public Medicament() {
        this.prescribedPatients = new HashSet<>();
    }

    public Medicament(String name) {
        this.name = name;
    }

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

    public Set<Patient> getPrescribedPatients() {
        return Collections.unmodifiableSet(prescribedPatients);
    }

    public void setPrescribedPatients(Set<Patient> prescribedPatients) {
        this.prescribedPatients = prescribedPatients;
    }
}
