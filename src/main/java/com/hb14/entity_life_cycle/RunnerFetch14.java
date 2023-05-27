package com.hb14.entity_life_cycle;

import com.hb13.get_load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch14 {

    public static void main(String[] args) {

        Student14 student1 = new Student14(); // !!! Transient
        student1.setName("Kasim");
        student1.setMathGrade(55);

        Student14 student2 = new Student14(); // !!! Transient
        student1.setName("Gulsen");
        student1.setMathGrade(65);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1); // !!! persistent state -- Datayi takibe aldi

        student1.setName("hakki");

        session.evict(student1); // detached --> artik bu objeyi kafasindan siler takip etmez

        student1.setName("hakki"); // onje life-cycle olarak hala detach asamasinda oldugu icin isim degismez

        session.update(student1); // persistent scope --> takibe aldi yine
        session.merge(student1); // persistent scope --> takibe aldi yine




        tx.commit();
        session.close();
        sf.close();



    }
}
