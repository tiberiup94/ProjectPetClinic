package org.example.clinic;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name =  "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOwner;

    private String name;
    private String phone;
    private String mail;
    private String address;


    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Owner(String name, String phone, String mail, String address, Set<Pet> pets) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.pets = pets;
    }



    public Owner() {
    }

    public Integer getId() {
        return idOwner;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Owner{");
        sb.append("idOwner=").append(idOwner);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", mail='").append(mail).append('\'');
        sb.append(", address='").append(address).append('\'');
//        sb.append(", pets=").append(pets);
        sb.append('}');
        return sb.toString();
    }
}
