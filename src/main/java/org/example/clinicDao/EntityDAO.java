package org.example.clinicDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.clinic.Pet;

import java.util.List;

public abstract class EntityDAO<T>{
    protected EntityManagerFactory entityManagerFactory;

    protected T entity;

    public EntityDAO(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("yourPersistenceUnitName");
    }

    public void delete(T t){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

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



    public List<T> displayAll(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String name = this.entity.getClass().getSimpleName();
        String hql = "FROM " + name;
        List<T> list = entityManager.createQuery(hql).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;


    }




}
