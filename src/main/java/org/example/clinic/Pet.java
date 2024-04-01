package org.example.clinic;

import jakarta.persistence.*;

@Entity
@Table (name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPet;

    private String species;
    private String breed;
    private String name;
    private int age;
    private double weight;
    private Integer ownerId;

    public Pet(String species, String breed, String name, int age, double weight, Integer ownerId) {
        this.species = species;
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.ownerId = ownerId;
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

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
