package org.example.clinicDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.clinic.Owner;
import org.example.clinic.Pet;

public class OwnerDAO extends EntityDAO<Owner> {


    private EntityManagerFactory entityManagerFactory;

    public OwnerDAO(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("yourPersistanceUnitName");
    }


    public void createOwner(Owner owner){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{

            entityManager.getTransaction().begin();
            entityManager.persist(owner);
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

    public Owner readPetById( Integer ownerId ){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Owner.class, ownerId);
        }   finally{
            entityManager.close();
        }

    }


    public void updateOwner(Owner owner){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{

            entityManager.getTransaction().begin();
            entityManager.merge(owner);
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



}
