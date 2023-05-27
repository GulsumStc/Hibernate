package com.hb11tekrar.CriteriaApi;

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
import java.util.Random;
import java.util.SimpleTimeZone;

public class RunnerFetch {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Barinak.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx  =  session.beginTransaction();

        // Update id'si 5 olan animal "hasta animal" olarak degistir.
        // get
//        Barinak animal = session.get(Barinak.class,5L);
//        animal.setName("Hasta"+animal.getName());

        //  weight'i >8 olan hayvanlara diyet prog. uygula 7 kiloya dussunler

//        String sqlQuery = "update barinak set weight = 7 where weight > 8";
//        int updatedrecords = session.createSQLQuery(sqlQuery).executeUpdate();
//        System.out.println(" guncellenen kayit sayisi: "+updatedrecords);

        // HQL - Degisken tanimla

//        int sWeight = 8;
//        int lWeight = 6;
//
//        String hqlQuery = " update Barinak set weight = :sWeight where weight >=:lWeight";
//        Query<Barinak> query = session.createQuery(hqlQuery);
//        query.setParameter("sWeight",sWeight);
//        query.setParameter("lWeight",lWeight);
//        int updatedrecords1 =  query.executeUpdate();
//        System.out.println(" guncellenen kayit sayisi: "+updatedrecords1);
//

   // ------------------------- criteriaApi --------------------------------

       CriteriaBuilder cb =  session.getCriteriaBuilder();
       CriteriaQuery<Barinak> criteriaQuery = cb.createQuery(Barinak.class);
       Root<Barinak> root =  criteriaQuery.from(Barinak.class);

       // tum animallari yazdirin

//        criteriaQuery.select(root); // select * from barinak;
//        Query<Barinak> query1 =  session.createQuery(criteriaQuery);
//        List<Barinak> resultList = query1.getResultList();
//        resultList.forEach(System.out::println);
//
        // id'si 11 olan animal bilgilerini getirisin
//
//        criteriaQuery.select(root).where(cb.equal(root.get("id"),11));
//        Barinak animal = session.createQuery(criteriaQuery).uniqueResult();
//        System.out.println(animal);

        // adi "animal 18" olan animal'in bilgilerini getir

//        criteriaQuery.select(root).where(cb.equal(root.get("name"),"animal 18"));
//        Barinak animal = session.createQuery(criteriaQuery).uniqueResult();
//        System.out.println(animal);

        //weight  değeri  5 den küçük esit olan datalar

//        criteriaQuery.select(root).where(cb.lessThanOrEqualTo(root.get("weight"),5));
//        List<Barinak> list = session.createQuery(criteriaQuery).getResultList();
//        list.forEach(t-> System.out.println(t));

        // id si 8 veya weight i 4 den büyük olan recordu bulalım.
        // ve / veya
    //    criteriaQuery.select(root).where(cb.equal(root.get("id"),8),cb.greaterThan(root.get("weight"),4));

        // Predicate = creteria in criteria
        Long  id = 15L;
        Predicate predicateForId = cb.equal(root.get("id"),id);// 1. sorgu
        Predicate predicateForWeight = cb.greaterThan(root.get("weight"),5);// 2. sorgu
        Predicate predicateQuery = cb.or(predicateForId,predicateForWeight);
        criteriaQuery.where(predicateQuery);
        List<Barinak> list1 = session.createQuery(criteriaQuery).getResultList();
        list1.forEach(System.out::println);




































        tx.commit();
        session.close();
        sf.close();


    }


}
