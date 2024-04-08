package org.example.clinic;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "veterinary")
public class Veterinary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVet;

    private String name;
    private String phone;
    private String mail;
    private String speciality;

    @OneToMany(mappedBy = "vet", fetch = FetchType.LAZY)
    private Set<Appointment> appointments = new HashSet<>();


    public Veterinary(String name, String phone, String mail, String speciality, Set<Appointment> appointments) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.speciality = speciality;
        this.appointments = appointments;
    }

    public Veterinary() {
    }

    public Integer getId() {
        return idVet;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Veterinary{");
        sb.append("idVet=").append(idVet);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", mail='").append(mail).append('\'');
        sb.append(", speciality='").append(speciality).append('\'');
      //  sb.append(", appointments=").append(appointments);
        sb.append('}');
        return sb.toString();
    }
}
