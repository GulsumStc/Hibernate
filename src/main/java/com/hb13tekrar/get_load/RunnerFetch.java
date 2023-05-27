package com.hb13tekrar.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

       //DB' mevcut
//        System.out.println("--------------------- get methodu basladi-----------------------");
//
//        Student student1 = session.get(Student.class,1L);
//
//        System.out.println("--------------------- get methodu bitti -----------------------");
//
//        System.out.println("Student ID: "+ student1.getId());
//        System.out.println("Student Name: "+ student1.getName());
//
//
//
//        System.out.println("--------------------- load methodu basladi-----------------------");
//
//        Student student2 = session.load(Student.class,2L);
//
//        System.out.println("--------------------- load methodu bitti -----------------------");
//
//        System.out.println("Student ID: "+ student2.getId());
//        System.out.println("Student Name: "+ student2.getName());


//        Student student3 = session.get(Student.class,10L);
//       // System.out.println(student3);
//
//        if (student3 !=null){ //null
//            System.out.println(student3.getId()+ "---"+student3.getName());
//        }
//
//
//        System.out.println("--------------------------------------------");
//
//
//        Student student4 = session.load(Student.class,10L); // proxy
//       // System.out.println(student4);
//
//        if (student4 != null){
//            System.out.println(student4.getId()+ "---"+student4.getName());
//        }


        //delete

        Student student5 = session.get(Student.class,4L);
        session.delete(student5);

        System.out.println("--------------------------------------------");

        Student student6 = session.load(Student.class,5L);

        System.out.println("---------------------------------------------");

        session.delete(student6);













        tx.commit();
        session.close();
        sf.close();


    }
}
