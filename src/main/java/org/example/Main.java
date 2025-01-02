package org.example;

import org.example.entities.Certification;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(org.example.entities.Student.class);
        configuration.addAnnotatedClass(org.example.entities.Certification.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        try {
            session.beginTransaction();
            Student aayu=new Student();
            aayu.setName("aayu");

            Student aryan=new Student();
            aryan.setName("aryan");

            Student harry=new Student();
            harry.setName("harry");

            Certification awsCloud=new Certification();
            awsCloud.setCertificationName("Aws Cloud Practitioner");

            Certification oracleJava=new Certification();
            oracleJava.setCertificationName("Oracle Java Developer");

            Certification vnware=new Certification();
            vnware.setCertificationName("Spring Certified Developer");

            Student existing=session.get(Student.class,1);


            Set<Certification> aayuCertificates=new HashSet<>();
//            aayuCertificates.add(oracleJava);
            aayuCertificates.add(awsCloud);

            existing.setCertifications(aayuCertificates);

            Set<Certification> aryancertificates=new HashSet<>();
//            aryancertificates.add(oracleJava);
//            aryancertificates.add(awsCloud);
//            aryancertificates.add(vnware);

            Set<Certification> harryCertificates=new HashSet<>();
//            harryCertificates.add(awsCloud);
//            harryCertificates.add(vnware);

            aayu.setCertifications(aayuCertificates);
            aryan.setCertifications(aryancertificates);
            harry.setCertifications(harryCertificates);


            session.persist(aayu);
//            session.persist(aryan);
//            session.persist(harry);

            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();

        }
    }
}