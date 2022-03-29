package com.example.football.models.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatDTO {

    @XmlElement(name = "passing")
    private float passing;

    @XmlElement(name = "shooting")
    private float shooting;

    @XmlElement(name = "endurance")
    private float endurance;

    public StatDTO() {
    }

    @Positive
    @DecimalMin("01.0")
    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    @Positive
    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    @Positive
    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }
}
