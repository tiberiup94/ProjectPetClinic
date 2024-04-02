package org.example.clinic;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApp;

    private Date date;
    private String reason;


    @ManyToOne
    @JoinColumn(name = "pet_id")
    private  Pet pet;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private  Veterinary vet;

    public Appointment(Pet pet, Veterinary vet, Date date, String reason) {
        this.pet = pet;
        this.vet = vet;
        this.date = date;
        this.reason = reason;
    }
    public Appointment(){

    }

    public Integer getIdApp() {
        return idApp;
    }


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Veterinary getVet() {
        return vet;
    }

    public void setVet(Veterinary vet) {
        this.vet = vet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
