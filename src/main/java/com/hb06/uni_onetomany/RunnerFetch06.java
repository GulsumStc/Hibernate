package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {

    public static void main(String[] args) {



        Configuration cfg = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//       //get
//
//        Student06 student = session.get(Student06.class,1001);
//        System.out.println(student);
//
//        //HQL
//        // !!! HQL ile id si 101 olan kitabı getirelim
//        String hqlQuery = " from Book06  b where b.id = 101";
//        Book06 book1 = session.createQuery(hqlQuery, Book06.class).uniqueResult();
//        System.out.println(book1);

        System.out.println("******************************************************************888");
        String hqlQuery2 = " select name  from Student06 s inner join fetch   where s.bookList = 1001";
        Book06 book2 = session.createQuery(hqlQuery2, Book06.class).uniqueResult();
        System.out.println(book2);



        //adem bey
       // String hqlFound = "b FROM Student06 s  WHERE s.id = 1001 INNER JOIN FETCH Book06 b ON s.id = b.booklist_id";


       // String hqlQuery2 = "Select    from  where   ";

        tx.commit();
        session.close();
        sf.close();


    }
}
