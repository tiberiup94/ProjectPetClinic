package org.example.clinicDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.clinic.Owner;
import org.example.clinic.Pet;

import java.util.List;

public class OwnerDAO extends EntityDAO<Owner> {


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

    public Owner readOwnerById( Integer ownerId ){
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


    public List<Owner> displayOwnerByPhone(String phone){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String hql = "FROM Owner WHERE phone = '" + phone + "'";
        List<Owner> list = entityManager.createQuery(hql).getResultList();
//      entityManager.getTransaction().commit();
        entityManager.close();
        return list;


    }


}
