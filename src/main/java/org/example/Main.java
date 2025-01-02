package org.example;

import org.example.entities.Student;
import org.example.entities.StudentCollege;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(org.example.entities.Student.class);
        configuration.addAnnotatedClass(org.example.entities.StudentCollege.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();

        try{
            session.beginTransaction();
            Student aayu=new Student();
            aayu.setName("Aayu");

            Student aryan=new Student();
            aryan.setName("Aryan");

            Student harry=new Student();
            harry.setName("Harry");

            StudentCollege ddu=new StudentCollege();
            ddu.setCollegeName("DDU");

            StudentCollege ld=new StudentCollege();
            ld.setCollegeName("LD college");

            aayu.setStudentCollege(ddu);
            aryan.setStudentCollege(ld);
            harry.setStudentCollege(ddu);

            List dduStudents=new ArrayList();
            dduStudents.add(aayu);
            dduStudents.add(harry);

            List ldStudents=new ArrayList();
            ldStudents.add(aryan);

            ddu.setStudents(dduStudents);
            ld.setStudents(ldStudents);
            session.persist(aayu);
            session.persist(aryan);
            session.persist(harry);

            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}