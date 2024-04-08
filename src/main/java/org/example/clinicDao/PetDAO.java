package org.example.clinicDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.clinic.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetDAO extends EntityDAO<Pet>{


//    public PetDAO(){
//        this.entityManagerFactory = Persistence.createEntityManagerFactory("yourPersistenceUnitName");
//
//    }

    public void createPet(Pet pet){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{

            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

    }


    public Pet readPetById( Integer petId ){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Pet.class, petId);
        }   finally{
            entityManager.close();
        }

    }

    public void updatePet(Pet pet){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{

            entityManager.getTransaction().begin();
            entityManager.merge(pet);
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {

                entityManager.close();

        }

    }


//    @Override
//    public List<Pet> displayAll(){
////        List<Pet> pets = new ArrayList<>();
////        pets = super.displayAll();
////        OwnerDAO ownerDAO = new OwnerDAO();
////        for(Pet pet: pets) {
////            pet.setOwner(ownerDAO.findOwnerByPetId(pet.getIdPet()));
////            pet.setAppointments(app.);
////        }
//
//
//
//    }




}
