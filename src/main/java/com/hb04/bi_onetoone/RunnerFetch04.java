package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch04 {


    public static void main(String[] args) {


        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                                    addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // belirli id'li student getirelim

        Student04 student = session.get(Student04.class,1001);


        //diary geyirelim

        Diary04 diary = session.get(Diary04.class,101);
        System.out.println(student);

/*
StackOverflowError : student'i yazdigimda  hem student ta hemde Diary'de to string methodunda birbiri icinde
                        field'lar oldugundan recursive olustu ve stacoverflow hatasi aldik cunku dtudent'tan diary diary'den
                        studnta gidiyor
 */

        System.out.println("*************** diary bilgisini basalim ****************");
        System.out.println(diary);
        System.out.println("** Diary uzerinden Student06 objesine ulasalim --->>"+  diary.getStudent());

        // student noktasinda student uzerinden set diary yapmadim simdi Student06 uzerinden ulasmaya calisalim
        // burada istedgimiz yapi gelecek mi??

        System.out.println("** Student06 uzerinden diary objesine ulasalim --->>"+  student.getDiary());


        //**** Task : Kesisim kumesini bana getir (INNER JOIN)
        //            Yani gunlugu olan ogrencileri getir diyoruz

        //hql'de class fieldlarin degisken isimlerini kullaniyorum Dikkat!!!!!
        // hql'de joinle fetch kelimesini kullaniyoruz
        String hqlQuery = "select s.name, d.name  from Student04 s INNER JOIN FETCH Diary04 d on s.id = d.student";
        // iki farkli clas'tan veri geldiginden mapleme yapamam ne student'a neden diary'e mapleyebilirim
        List<Object[]> resulset= session.createQuery(hqlQuery).getResultList();
        //foreach
//        for (Object[] objects: resulset ) {
//            System.out.println(Arrays.toString(objects));
//        }
        //Lambda foreach

        resulset.forEach( t -> {
            System.out.println(Arrays.toString(t));
        });

        //***** Task 2: HQL LEFT JOIN
        // bana tum ogencileri getir eger gelen ogrencilerin diarileri varsa diary bilgilerinide getir
        //arasindaki fark:
        //Select * from Student04  --> burada satece Student06 tablosundaki bilgileri getirir
        // ile
        // Left join kullanmak --> hem student tablosundaki field'lari hemde diary 'le eslesen fieldlar gelsin


        String hqlQuery1 = " select s.name ,d.name from Student04 s LEFT JOIN FETCH Diary04  d on  s.id = d.student";

        List<Object[]> resulset2 = session.createQuery(hqlQuery1).getResultList();

        resulset2.forEach(t-> System.out.println(Arrays.toString(t)));


        //***** Task 3: HQL RIGH JOIN
        //butun gunlunler ve varsa gunlugu olan  ogrenciler gelsin

       String hqlQuery2 = " select s.name ,d.name from Student04 s RIGHT JOIN FETCH Diary04 d ON s.id = d.student";

       List<Object[]> resulset3 = session.createQuery(hqlQuery2).getResultList();
       resulset3.forEach(t-> System.out.println(Arrays.toString(t)));

        //***** Task 4: HQL FULL JOIN
        //Kisaca: butun student ve diary bilgilerini getir

        String hqlQuery3 = " select s.name ,d.name from Student04 s FULL JOIN FETCH Diary04 d ON s.id = d.student";

        List<Object[]> resulset4 = session.createQuery(hqlQuery3).getResultList();
        resulset4.forEach(t-> System.out.println(Arrays.toString(t)));



        tx.commit();
        session.close();
        sf.close();



    }
}
