package softuni.exam.models.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    private String make;

    private String model;

    private Integer kilometers;

    @Column(name = "registered_on")
    private LocalDate registeredOn;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    public Car() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return String.format("Car make - %s%n" +
                        "\tmodel %s%n" +
                        "\tKilometers - %o%n" +
                        "\tRegistered on - %s%n" +
                        "\tNumber of pictures - %o%n",
                        this.make, this.model, this.kilometers, this.registeredOn, this.pictures.size());
    }
}


