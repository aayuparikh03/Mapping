package org.example;

import org.example.entities.Certification;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;
//Commented code is also okay but it is using for adding data for the 1st time to database.
//Uncommented code is fetching data from database and add a new certificate in database in existing data.
public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(org.example.entities.Student.class);
        configuration.addAnnotatedClass(org.example.entities.Certification.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        try {
            session.beginTransaction();
//            Student aayu=new Student();
//            aayu.setName("aayu");
//
//            Student aryan=new Student();
//            aryan.setName("aryan");
//
//            Student harry=new Student();
//            harry.setName("harry");
//
//            Certification awsCloud=new Certification();
//            awsCloud.setCertificationName("Aws Cloud Practitioner");
//
//            Certification oracleJava=new Certification();
//            oracleJava.setCertificationName("Oracle Java Developer");
//
//            Certification vnware=new Certification();
//            vnware.setCertificationName("Spring Certified Developer");
//
//            session.persist(awsCloud);
//            session.persist(oracleJava);
//            session.persist(vnware);
//
//
//
////
////
//            Set<Certification> aayuCertificates=new HashSet<>();
//            aayuCertificates.add(oracleJava);
//            aayuCertificates.add(awsCloud);
//
//
//            Set<Certification> aryancertificates=new HashSet<>();
//            aryancertificates.add(oracleJava);
//            aryancertificates.add(awsCloud);
//
////
//            Set<Certification> harryCertificates=new HashSet<>();
//            harryCertificates.add(awsCloud);
//            harryCertificates.add(vnware);
//
//            aayu.setCertifications(aayuCertificates);
//            aryan.setCertifications(aryancertificates);
//            harry.setCertifications(harryCertificates);
//
//
//            session.persist(aayu);
//            session.persist(aryan);
//            session.persist(harry);


            Student harry = session.get(Student.class, 3);
            Certification newCerti = session.get(Certification.class, 2);

            harry.getCertifications().add(newCerti);

            session.persist(newCerti);
            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();

        }
    }
}