package HospitalDatebase.entities;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(unique = true)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Lob
    private Blob picture;

    private boolean isInsured;

    @ManyToMany(mappedBy = "diagnosedPatients", targetEntity = Diagnose.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Diagnose> diagnoses;

    @OneToMany(mappedBy = "patient", targetEntity = Visitation.class)
    private Set<Visitation> visitations;

    @ManyToMany(mappedBy = "prescribedPatients", targetEntity = Medicament.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Medicament> medicaments;

    public Patient() {
        this.diagnoses = new HashSet<>();
        this.visitations = new HashSet<>();
        this.medicaments = new HashSet<>();
    }

    public Patient(String firstName, String lastName, String address, String email, LocalDate dateOfBirth, Blob picture, boolean isInsured) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.picture = picture;
        this.isInsured = isInsured;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }


    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}
