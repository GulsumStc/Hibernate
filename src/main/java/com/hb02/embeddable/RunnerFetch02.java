package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {


    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
                                       // mapladigim class, id(unique)
        Student02 student = session.get(Student02.class, 1001);
        // Eger ki adres bilgimi ayri class almasaydim tum field'lari tek tek alacaktim.
        // embaddable ile sadece getAddress yaparak cagiriyorum.
        System.out.println(student);
        System.out.println(student.getAddress());


        tx.commit();
        session.close();
        sf.close();


    }
}
