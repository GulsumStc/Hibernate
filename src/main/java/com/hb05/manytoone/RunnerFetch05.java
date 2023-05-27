package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {


        org.hibernate.cfg.Configuration cfg = new Configuration().
                configure("hibernate.cfg.xml"). //enttiy classlarimi configrasyon dosyasinda belirticem
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //Get methodu

        Student05 student = session.get(Student05.class,1001);// normalde bu id frontend kisminda gelir.
                                                    // ama simdi frontend tarafi olmadiginda kendiiz yaiyoruz
        System.out.println(student);
        System.out.println(student.getUniversity());

        // !!! HQL ile 1 id li universiteye giden butun ogrencileri bulalim

        String hqlQuery = " from Student05 where university.id = 1";
        List<Student05> students =  session.createQuery(hqlQuery,Student05.class).getResultList();

        students.forEach(System.out::println);



        tx.commit();
        session.close();
        sf.close();


    }
}
