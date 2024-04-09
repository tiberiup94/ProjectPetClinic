package org.example;

import org.example.clinic.Appointment;
import org.example.clinic.Owner;
import org.example.clinic.Pet;
import org.example.clinic.Veterinary;
import org.example.clinicDao.*;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static  AppointmentDAO appointmentDAO = new AppointmentDAO();
    static OwnerDAO ownerDAO = new OwnerDAO();
    static PetDAO petDAO = new PetDAO();
    static VeterinaryDAO veterinaryDAO = new VeterinaryDAO();
    public static void main(String[] args) {

//        AppointmentDAO appointmentDAO = new AppointmentDAO();
//        OwnerDAO ownerDAO = new OwnerDAO();
//        PetDAO petDAO = new PetDAO();
//        VeterinaryDAO veterinaryDAO = new VeterinaryDAO();
//
//        Owner owner1 = new Owner("Marcel", "0722222222", "marcel@yahoo.com", "Bucuresti, nr 30", null);
//        //ownerDAO.createOwner(owner1);
//        System.out.println(owner1.getName() + " " + owner1.getPets());
//
//        Pet pet1 = new Pet("Dog", "Husky", "Bruno", 4, 30.5, owner1, new HashSet<>());
//        //petDAO.createPet(pet1);
//        System.out.println(pet1.getName() + " with its owner " + pet1.getOwner().getName());
//
//        Veterinary vet1 = new Veterinary("Dr. Ion", "073333333", "drion@gmail.com", "surgeon", new HashSet<>());
//        //veterinaryDAO.createVeterinary(vet1);
//        System.out.println(vet1.getName());
//
//        Appointment app1 = new Appointment(pet1, vet1, new Date(), "vaccines");
//        //appointmentDAO.createAppointment(app1);
//        System.out.println("_");
//
//        //petDAO.delete(petDAO.readPet(1));
//
//        //Pet petUpdate = petDAO.readPet(2);
//        //petUpdate.setName("Barky");
//        //petDAO.updatePet(petUpdate);
//
//        //petDAO.displayAll();
//
//        System.out.println("afisam peturile ");
//        List<Pet> list = petDAO.displayAll();
//        for(Pet pet : list)
//            System.out.println(pet.toString());

        System.out.println("Welcome to the Pet-Clinic!\n" + "Please choose one of the following options:");
        String start;

        while (true){

            System.out.println("0 - End session");
            System.out.println("1 - Register a veterinary");
            System.out.println("2 - Display all veterinaries");
            System.out.println("3 - Register a pet owner");
            System.out.println("4 - Display all pet owners");
            System.out.println("5 - Register a pet");
            System.out.println("6 - Display all pet");
            System.out.println("7 - Add an appointment");
            System.out.println("8 - Delete owner");
            System.out.println("9 - Update pet");
            System.out.println("10 - Display owner by phone");

            start = scanner.nextLine();

            if ("0".equals(start)) {
                break;
            }

            switch (start) {

                case "1":
                    registerVeterinary();
                    break;
                case "2":
                    displayVeterinaries();
                    break;
                case "3":
                    registerOwner();
                    break;
                case "4":
                    displayOwners();
                    break;
                case "5":
                    registerPet();
                    break;
                case "6":
                    displayPets();
                    break;
                case "7":
                    addAppointment();
                    break;
                case "8":
                    deleteOwner();
                    break;
                case "9":
                    updatePet();
                    break;
                case "10":
                    displayOwnerByPhone();
                    break;
                default :
                    System.out.println("Unkown command.");


            }

        }
    }


    static public void registerVeterinary (){

        System.out.println("Register veterinary name: ");
        String name = scanner.nextLine();
        System.out.println("Phone: ");
        String phone = scanner.nextLine();
        System.out.println("Mail: ");
        String mail = scanner.nextLine();
        System.out.println("Speciality ");
        String speciality = scanner.nextLine();

        Veterinary veterinary1 = new Veterinary(name, phone, mail, speciality, new HashSet<>());
        veterinaryDAO.createVeterinary(veterinary1);
    }

    static public void displayVeterinaries(){
        List<Veterinary> list = veterinaryDAO.displayAll();
        for(Veterinary veterinary : list){
            System.out.println(veterinary.toString());
        }
    }

    static public void registerOwner (){

        System.out.println("Register owner name: ");
        String name = scanner.nextLine();
        System.out.println("Phone: ");
        String phone = scanner.nextLine();
        System.out.println("Mail: ");
        String mail = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();

        Owner owner1 = new Owner(name, phone, mail, address, new HashSet<>());
        ownerDAO.createOwner(owner1);
    }

    static public void displayOwners(){
        List<Owner> list = ownerDAO.displayAll();
        for(Owner owner : list){
            System.out.println(owner.toString());
        }
    }

    static public void registerPet (){

        System.out.println("Register pet species: ");
        String species = scanner.nextLine();
        System.out.println("Breed: ");
        String breed = scanner.nextLine();
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        System.out.println("Weight: ");
        double weight = scanner.nextDouble();
        System.out.println("Owner Id: ");
        int id = scanner.nextInt();
        Owner owner1 = ownerDAO.readOwnerById(id);

        Pet pet1 = new Pet(species, breed, name, age, weight, owner1, new HashSet<>());
        petDAO.createPet(pet1);

    }

    static public void displayPets(){
        List<Pet> list = petDAO.displayAll();
        for(Pet pet : list){
            System.out.println( pet.toString());
        }
    }

    static public void addAppointment (){

        Date date = new Date();
        System.out.println("ReasonNEW: ");
        String reason1 = scanner.nextLine();
        System.out.println("Add pet Id: ");
        int idPet = scanner.nextInt();
        Pet pet = petDAO.readPetById(idPet);
        System.out.println("Vet Id: ");
        int idVet = scanner.nextInt();
        Veterinary veterinary1 = veterinaryDAO.readVeterinary(idVet);

        System.out.println("Thank you ");

        Appointment app1 = new Appointment(pet,veterinary1,date,reason1);
        appointmentDAO.createAppointment(app1);

    }

    public static void deleteOwner(){
        System.out.println("Delete the following Owner Id: ");
        int idOwner = scanner.nextInt();
        ownerDAO.delete(ownerDAO.readOwnerById(idOwner));
    }


    public static void displayOwnerByPhone(){

        System.out.println("Display the following Owner Phone: ");
        String phone = scanner.nextLine();
        List<Owner> list = ownerDAO.displayOwnerByPhone(phone);
        for(Owner owner : list){
            System.out.println(owner.toString());
        }

    }

    public static void updatePet(){
        System.out.println("Update the following Pet Id: ");
        int idPet = scanner.nextInt();
        Pet petUpdated = petDAO.readPetById(idPet);
        System.out.println("Current parameters: ");
        System.out.println(petUpdated.toString());
        System.out.println("New age: ");
        int newAge = scanner.nextInt();
        System.out.println("New weight: ");
        double newWeight = scanner.nextDouble();
        petUpdated.setAge(newAge);
        petUpdated.setWeight(newWeight);
        petDAO.updatePet(petUpdated);
    }

}