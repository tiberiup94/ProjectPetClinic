package org.example.clinicDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SessionDAO<T> {

    private SessionFactory sessionFactory;
    Session session = sessionFactory.openSession();

    public void delete(T t){
        Transaction tx = null;
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
