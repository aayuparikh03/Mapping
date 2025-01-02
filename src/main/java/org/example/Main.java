package org.example;

import org.example.entities.Student;
import org.example.entities.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(org.example.entities.Student.class);
        configuration.addAnnotatedClass(org.example.entities.StudentDetails.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        try{
            session.beginTransaction();
            StudentDetails aayuDetails=new StudentDetails();
            aayuDetails.setZipcode(389001);

            Student aayu=new Student();
            aayu.setName("Aayu");
            aayu.setStudentDetails(aayuDetails);

            session.persist(aayu);
            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}