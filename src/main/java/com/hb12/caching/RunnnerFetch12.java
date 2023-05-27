package com.hb12.caching;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnnerFetch12 {

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx =session.beginTransaction();

        //First Level cach: session seviyesinde cachleme yapiyor

        System.out.println("Ilk get islemi 1 id'li ogrenci icin");
        Student12 student1 = session.get(Student12.class,1L); // tek sorgu olustu. cash yapildi

//        session.clear();// student iki icin simdi sorgu olusturacak cunku clear ile sesion'ni sifirladik!!!!
//                        //first level cach olmasa? --> biz bir query ayni session icinde 100 defa calistirsak
//                        // 100 defa DB'ye  gitmek zorunda kalir.
//
//        System.out.println("ikinci  get islemi 1 id'li ogrenci icin");
//        // ikinci bir query atmadi first level cach aktif oldu. DB ye gitmedi
//        Student12 student2 = session.get(Student12.class,1L);


        tx.commit();
        session.close();

        // yeni bir query atabilmek icin yeni bir sesion aciyorum.
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();


        System.out.println("session close sonrasi  get islemi 1 id'li ogrenci icin");
        Student12 student3 = session2.get(Student12.class,1L);

        //First Level cach session'lar arasi calismaz

        tx2.commit();
        session2.close();



        sf.close();
    }
}
