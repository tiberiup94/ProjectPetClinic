package org.example.clinicDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.clinic.Pet;

import java.util.List;

public class EntityDAO<T>{
    private EntityManagerFactory entityManagerFactory;
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void delete(T t){


        try{

            entityManager.getTransaction().begin();
            T toRemove = entityManager.contains(t) ? t : entityManager.merge(t);
            entityManager.remove(toRemove);
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

    public List<T> displayAll(String entityName){



        String hql = "FROM " + entityName;
        List<T> list = entityManager.createQuery(hql).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;


    }




}
