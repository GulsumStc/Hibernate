package com.hb11tekrar.CriteriaApi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave {

    public static void main(String[] args) {


        Configuration cfg = new Configuration().configure().addAnnotatedClass(Barinak.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx  =  session.beginTransaction();

        Random random = new Random();

        for (int i = 0; i < 20; i++) {

            Barinak animal = new Barinak("animal "+i, random.nextInt(10)+1);
            session.save(animal);

        }



        tx.commit();
        session.close();
        sf.close();



    }
}
