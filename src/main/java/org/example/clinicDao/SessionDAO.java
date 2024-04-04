package org.example.clinicDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public abstract class SessionDAO<T> {

    protected SessionFactory sessionFactory;


    public SessionDAO(){
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void delete(T t){
        Transaction tx = null;
        Session session = sessionFactory.openSession();
        try{
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
        } catch(Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<T> displayAll(String entity) {

        Transaction tx = null;
        Session session = sessionFactory.openSession();
        List<T> list = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM " + entity;
            list = session.createQuery(hql).getResultList();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }


}
