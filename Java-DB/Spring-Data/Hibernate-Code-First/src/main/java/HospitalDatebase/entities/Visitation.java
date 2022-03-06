package HospitalDatebase.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    public Visitation(LocalDate date, String comments, Patient patient) {
        this.date = date;
        this.comments = comments;
        this.patient = patient;
    }

    public Visitation() {};






}
