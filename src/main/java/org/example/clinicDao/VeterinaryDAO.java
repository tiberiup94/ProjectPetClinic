package org.example.clinicDao;

import org.example.clinic.Veterinary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VeterinaryDAO extends SessionDAO<Veterinary>{

//    private SessionFactory sessionFactory;

//
//    public VeterinaryDAO(){
//        this.sessionFactory = new Configuration().configure().buildSessionFactory();
//    }

    public void createVeterinary(Veterinary veterinary){

        Session session= sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.persist(veterinary);
            tx.commit();

        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public Veterinary readVeterinary(Integer vetId){

        Veterinary veterinary = null;
        try(Session session = sessionFactory.openSession()){
            veterinary = session.get(Veterinary.class, vetId);
        } catch(Exception e){
            e.printStackTrace();
        }
        return veterinary;

    }










}
