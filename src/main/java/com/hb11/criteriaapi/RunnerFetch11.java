package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {

    public static void main(String[] args) {

        /*
            CRUD (Create, Read, Update, Delete)

              C --> Sesion.save
              R --> Session.get, HQL, SQL
              U --> Session.update, updateQuery
              D --> session.delete, HQL, SQL
         */

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx =session.beginTransaction();

        //!!! update islemi
//        Student11 student = session.get(Student11.class, 1L);//id data type Long oldugundan belirtiyorum.-->1L
//        student.setName("Guncellenmis " + student.getName());
//        session.update(student);

        // !!! Degisken tanimla
        // MathGrade puani 30 dan kucuk olan ogrencilerin puanlarini 80 yapalim

        int sMathGrade = 80;
        int lMathGrade = 30;

        String hqlQuery = "UPDATE Student11 s SET s.mathGrade=:sMath WHERE s.mathGrade<:lMath";
        Query query = session.createQuery(hqlQuery);

        query.setParameter("sMath", sMathGrade);
        query.setParameter("lMath", lMathGrade);

        int numOfRecords = query.executeUpdate();
        System.out.println("Degistirilen kayit sayisi : " + numOfRecords);


        // !!! CriteriaAPI ***************************************
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);
        //CriteriaBuilder'i kullanabilmem icin root objesine ulasmma gerek
        //Root objesi: ile hangi enttity class uzerinden criteria'yi kullanacaksam bunu hibernate soylemis oluyorum
        //hql ve sql ile yazabildigim tum query'leri CriteriaApi 'le yazabilirim.

        //!!! 1.Örnek: butun Student11 objelerini ekrana basalim:

//        criteriaQuery.select(root); // SELECT * FROM Student11
//        Query<Student11> query1 = session.createQuery(criteriaQuery);
//        List<Student11> resultList = query1.getResultList();
//        resultList.forEach(System.out::println);
//





        //!!! 2.Örnek , Student ismi "Student Name 6" olan öğrenci bilgilerini getirelim

//        criteriaQuery.select(root). // SELECT * FROM Student11
//                where(cb.equal(root.get("name"), "Student Name 6"));
//        Query<Student11> query2 = session.createQuery(criteriaQuery); // root objesinde data turunun Student11 oldugunu belirtmis oldum.
//        List<Student11> resultList2 = query2.getResultList();
//        resultList2.forEach(System.out::println);
//



        //!!!  3.Örnek, mathGrade değeri 80 den büyük olan dataları getirelim

//        criteriaQuery.select(root).
//                where(cb.greaterThan(root.get("mathGrade"), 80));
//        Query<Student11> query3 = session.createQuery(criteriaQuery);
//        List<Student11> resultList3 = query3.getResultList();
//        resultList3.forEach(System.out::println);


        
        //!!! 4.Örnek MathGrade değeri 95 den küçük olan datalar
//
//        criteriaQuery.select(root).
//                where(cb.lessThan(root.get("mathGrade"),95));
//        Query<Student11> query4 = session.createQuery(criteriaQuery);
//        List<Student11> resultList4 = query4.getResultList();
//        resultList4.forEach(System.out::println);

    // criteria icerisinde criteria kullanilmasina "predicate" olarak ifade edilir.
        // kod okunabilirligini arttirir.
        // karmasik sorgularda ozellikle or/and  yapilarinda kullanilir.

        // !!! 5. örnek : id si 1 veya mathGrade i 75 den büyük olan recordu bulalım.

        Long id = 1L;

        Predicate predicateForname = cb.equal(root.get("id"),id);
        Predicate predicateforGrade = cb.greaterThan(root.get("mathGrade"),75);
        Predicate predicateStd = cb.or(predicateForname,predicateforGrade);
        // artik elimde bir sorgu var

        criteriaQuery.where(predicateStd); //

        Query<Student11> query5 = session.createQuery(criteriaQuery);
        List<Student11> resultLsit5 = query5.getResultList();











        tx.commit();
        session.close();
        sf.close();
    }
}