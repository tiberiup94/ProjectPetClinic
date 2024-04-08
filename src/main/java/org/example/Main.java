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

import java.util.*;



public class Main {

    static Scanner scanner = new Scanner(System.in);

    static AppointmentDAO appointmentDAO = new AppointmentDAO();
    static OwnerDAO ownerDAO = new OwnerDAO();
    static PetDAO petDAO = new PetDAO();
    static VeterinaryDAO veterinaryDAO = new VeterinaryDAO();
    public static void main(String[] args) {






//        Owner owner1 = new Owner("Marcel", "0722222222", "marcel@yahoo.com", "Bucuresti 30", new HashSet<>());
//      //  ownerDAO.createOwner(owner1);
//        System.out.println(owner1.getName() + " " + owner1.getPets());
//
//        Pet pet1 = new Pet("Dog", "Husky", "Bruno", 4, 30.5, owner1, new HashSet<>());
//       // petDAO.createPet(pet1);
//        System.out.println(pet1.getName() + " Il are stapan pe  " + pet1.getOwner().getName());
//
//        Veterinary vet1 = new Veterinary("Marcu", "0733333333", "marcu@yahoo.com", "cainolog", new HashSet<>());
//      ///  veterinaryDAO.createVeterinary(vet1);
//        System.out.println(vet1.getName() + " ");
//
//
//
////        Appointment app1 = new Appointment(petDAO.readPetById(2),veterinaryDAO.readVeterinary(2), new Date(),"Bolnav");
//       // appointmentDAO.createAppointment(app1);
////        System.out.println(" vine " + app1.getPet() + " la control la " + " " + app1.getVet() + " la data de "+ app1.getDate());
//
////        petDAO.delete(petDAO.readPetById(1));
//
////          Pet petUpdate = petDAO.readPetById(2);
// //         petUpdate.setName("Lara");
////          petDAO.updatePet(petUpdate);
//
//
//        System.out.println("afisam peturile ");
//        List<Pet> list = petDAO.displayAll();
//        for(Pet pet : list){
//            System.out.println( pet.toString());
//        }


        System.out.println("Start programm...");
        String start;

        System.out.println("Alegeti litera pentru optiunea dorita :");
        System.out.println("A - Adauga un pet");
        System.out.println("B - Adauga un veterinar");
        System.out.println("C - Adauga un owner");
        System.out.println("D - Pune o programare");
        System.out.println("E - Arata Animalele din baza de date");


        while (true) {

            start = scanner.nextLine();

            if ("exit".equals(start)) {
                break;
            }


            switch (start.toLowerCase()) {

                    case "a":
                    adaugaPet();
                    break;

                    case "b":
                    adaugaVet();
                    break;

                    case "c":
                    adaugaApp();
                    break;

                    case "d":
                    adaugaStapan();
                    break;

                    case "e":
                        arataAnimale();
                        break;
                default :
                        System.out.println("Comanda nu este in lista");


            }


        }
    }

       static public void adaugaPet () {
            String text;
            System.out.println("Introduceti detaliile Pet-ului: ");
            System.out.println("Specie ");
            String specie = scanner.nextLine();
            System.out.println("Breed ");
            String breed = scanner.nextLine();
            System.out.println("Name ");
            String name = scanner.nextLine();
            System.out.println("Varsta ");
            int varsta = scanner.nextInt();
            System.out.println("Greutata ");
            double greutate = scanner.nextDouble();
            System.out.println("Id Stapan: ");
            int id = scanner.nextInt();
            Owner stapan = ownerDAO.readOwnerById(id);

            Pet pet1 = new Pet(specie, breed, name, varsta, greutate, stapan, new HashSet<>());
            petDAO.createPet(pet1);

        }

    static public void adaugaVet () {
        String text;
        System.out.println("Introduceti detaliile Vet-ului: ");
        System.out.println("Name ");
        String name = scanner.nextLine();
        System.out.println("Telefon ");
        String telefon = scanner.nextLine();
        System.out.println("Mail ");
        String mail = scanner.nextLine();
        System.out.println("Speciality ");
        String specialitate = scanner.nextLine();


        Veterinary vet1 = new Veterinary(name, telefon, mail, specialitate, new HashSet<>());
        veterinaryDAO.createVeterinary(vet1);

    }


    static public void adaugaApp () {
        String text;
        System.out.println("Introduceti detaliile Programarii: ");
        System.out.println("Id Pet ");
        int idPet = scanner.nextInt();
        Pet pet = petDAO.readPetById(idPet);
        System.out.println("Id Vet ");
        int idVet = scanner.nextInt();
        Veterinary vet = veterinaryDAO.readVeterinary(idVet);
        Date data = new Date();
        System.out.println("Motiv ");
        String motive = scanner.nextLine();


        Appointment app1 = new Appointment(pet, vet, data, motive);
        appointmentDAO.createAppointment(app1);

    }

    static public void adaugaStapan () {
        String text;
        System.out.println("Introduceti detaliile Stapanului: ");
        System.out.println("Name ");
        String name = scanner.nextLine();
        System.out.println("Telefon ");
        String telefon = scanner.nextLine();
        System.out.println("Mail ");
        String mail = scanner.nextLine();
        System.out.println("Adresa ");
        String adresa = scanner.nextLine();


        Owner stapan = new Owner(name, telefon, mail, adresa, new HashSet<>());
       ownerDAO.createOwner(stapan);

    }

    static public void arataAnimale(){


        List<Pet> list = petDAO.displayAll();
        for(Pet pet : list){
            System.out.println( pet.toString());
        }

    }

}



///// stergere la toate si update