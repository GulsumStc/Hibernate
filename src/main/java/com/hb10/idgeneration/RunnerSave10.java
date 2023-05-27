package com.hb10.idgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student1 = new Student10();
        student1.setName("Ahmet");
        student1.setGrade(90);
        Student10 student2 = new Student10();
        student2.setName("Veli");
        student2.setGrade(70);
        Student10 student3 = new Student10();
        student3.setName("Ali");
        student3.setGrade(70);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

       // session.save(student1); // serilaziable tipinde id donuyor.
       // session.save(student2);

        tx.commit();

        session.save(student3); // save methodu transaction bittikten sonra bile calisir.

        session.close();
        sf.close();

    }
}