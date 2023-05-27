package com.hb13tekrar.get_load;

import com.hb13.get_load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {

    public static void main(String[] args) {


        Student student1 = new Student("Dunya",90);
        Student student2 = new Student("Irmak",80);
        Student student3 = new Student("Deniz",70);
        Student student4 = new Student("Deren",70);
        Student student5 = new Student("Yagmur",70);

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);



        tx.commit();
        session.close();
        sf.close();



    }
}
