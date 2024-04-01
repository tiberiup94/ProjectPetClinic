package org.example.clinic;


import jakarta.persistence.*;

@Entity
@Table(name =  "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOwner;

    private String name;
    private String phone;
    private String mail;
    private String address;


    public Owner(String name, String phone, String mail, String address) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
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
}
