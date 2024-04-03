package org.example.clinicDao;

import org.example.clinic.Appointment;
import org.example.clinic.Veterinary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppointmentDAO extends SessionDAO<Appointment> {



    private SessionFactory sessionFactory;


    public AppointmentDAO(){
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void createAppointment(Appointment appointment){

        Session session= sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.persist(appointment);
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

    public Appointment readAppointment(Integer appId){

        Appointment appointment = null;
        try(Session session = sessionFactory.openSession()){
            appointment = session.get(Appointment.class, appId);
        } catch(Exception e){
            e.printStackTrace();
        }
        return appointment;

    }
}
