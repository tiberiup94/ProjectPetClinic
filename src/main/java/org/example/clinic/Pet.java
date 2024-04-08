package org.example.clinic;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPet;

    private String species;
    private String breed;
    private String name;
    private int age;
    private double weight;
    // private Integer ownerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "owner_id")
    private Owner owner;


    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();


    public Pet(String species, String breed, String name, int age, double weight, Owner owner, Set<Appointment> appointments) {
        this.species = species;
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.owner = owner;
        this.appointments = appointments;
    }

    public Pet(){

    }


    public Integer getIdPet() {
        return idPet;
    }


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pet{");
        sb.append("idPet=").append(idPet);
        sb.append(", species='").append(species).append('\'');
        sb.append(", breed='").append(breed).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", weight=").append(weight);
        sb.append(", owner=").append(owner);
        sb.append(", appointments=").append(appointments);
        sb.append('}');
        return sb.toString();
    }
}
