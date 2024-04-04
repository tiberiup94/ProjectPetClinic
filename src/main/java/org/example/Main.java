package org.example;



//Pet Clinic
//
//        Description:
//
//        Implemented the Pet Clinic application model using Hibernate ORM framework to facilitate object-relational mapping.
//        Configured Hibernate annotations to define entity classes representing pets, owners, veterinarians and appointments.
//        Established mappings between entities and corresponding database tables to ensure data persistence.
//        Integrated Hibernate with a SQL database, leveraging MySQL for storing pet clinic data.
//        Implemented CRUD operations for managing pets, owners, veterinarians and appointments, ensuring seamless interaction between the application and the database.
//        Tested the functionality thoroughly to ensure proper data retrieval, storage, and manipulation.
//        Refactored code for improved readability, maintainability, and performance.
//        Resolved compatibility issues and optimized database queries for efficient data retrieval.
//        Updated documentation to reflect changes and provide comprehensive information on project structure and implementation details.
//
//
//        Welcome to the Pet-Clinic!
//        Please chose one of the following options:
//        0 - End session
//        1 - Register a veterinary
//        2 - Display all veterinaries
//        3 - Register a pet owner
//        4 - Display all pet owners
//        5 - Register a pet
//        6 - Display all pet
//        7 - Add an appointment


import org.example.clinic.Appointment;
import org.example.clinic.Owner;
import org.example.clinic.Pet;
import org.example.clinic.Veterinary;
import org.example.clinicDao.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        AppointmentDAO appointmentDAO =new AppointmentDAO();
        OwnerDAO ownerDAO = new OwnerDAO();
        PetDAO petDAO = new PetDAO();
        VeterinaryDAO veterinaryDAO = new VeterinaryDAO();


        Owner owner1 = new Owner("Marcel", "0722222222", "marcel@yahoo.com", "Bucuresti 30", new HashSet<>());
      //  ownerDAO.createOwner(owner1);
        System.out.println(owner1.getName() + " " + owner1.getPets());

        Pet pet1 = new Pet("Dog", "Husky", "Bruno", 4, 30.5, owner1, new HashSet<>());
       // petDAO.createPet(pet1);
        System.out.println(pet1.getName() + " Il are stapan pe  " + pet1.getOwner().getName());

        Veterinary vet1 = new Veterinary("Marcu", "0733333333", "marcu@yahoo.com", "cainolog", new HashSet<>());
      ///  veterinaryDAO.createVeterinary(vet1);
        System.out.println(vet1.getName() + " ");



        Appointment app1 = new Appointment(petDAO.readPetById(2),veterinaryDAO.readVeterinary(2), new Date(),"Bolnav");
       // appointmentDAO.createAppointment(app1);
        System.out.println(" vine " + app1.getPet() + " la control la " + " " + app1.getVet() + " la data de "+ app1.getDate());

//        petDAO.delete(petDAO.readPetById(1));

          Pet petUpdate = petDAO.readPetById(2);
 //         petUpdate.setName("Lara");
          petDAO.updatePet(petUpdate);

        List<Pet> listPet = petDAO.displayAll();
        for(Pet pet :  listPet) {
            System.out.println(pet.getName());
        }
    }
}