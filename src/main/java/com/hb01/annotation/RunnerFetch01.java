package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);


         SessionFactory sf = con.buildSessionFactory();
         Session session = sf.openSession();
         Transaction tx = session.beginTransaction();
         /*
         DB'den bilgi almak istiyorsam bunun 3 yolu var;
            1- get():
            2- SQL
            3- HQL

          SQL HQL arasindaki temel fark: SQL deki yapilarin yerine java objelerini kullaniyorum
          */

        //1. YOl - get():
        // ilgili db'ye gider 1001 id'li recordu aliyor ve student objesine donduruyor.
//        Student01 sutudent1 = session.get(Student01.class,1001);
//        Student01 sutudent2 = session.get(Student01.class,1002);
//        Student01 sutudent3 = session.get(Student01.class,1003);
//        System.out.println(sutudent1);
//        System.out.println(sutudent2);
//        System.out.println(sutudent3);// bu islemde uc defa select yapisini kullandi bu persormansla alakali bir sorundur
//                                        // DB'ye gider alir gelir ben get methodunu 3 defa calistiridim.


        //2.Yol

//        String sqlQuery = "Select * from t_student01";
//        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] objects: resultList ){
//            System.out.println(Arrays.toString(objects));
//        }


        //3.Yol : HQL :
        // Trick : HQL sorgusunda "from" dn sonra sinif ismi kullnilmali

        String hqlQuery = "from Student01";
        List<Student01> resulList2 = session.createQuery(hqlQuery, Student01.class).getResultList();

        for (Student01 student01: resulList2){
            System.out.println(student01);

        } // tek select query ile 3 sorgu geldi


        /*
        Hangi sorgu daha mantikli ?
        Yol:
Bu yöntemde, her bir öğrenci kaydı için ayrı bir get() sorgusu kullanılmıştır.
Bu durum, aynı veritabanı tablosundan verileri almak için birden fazla sorgu çalıştırıldığı anlamına gelir.
 Bu yöntem, performans sorunlarına neden olabilir.

Yol:
Bu yöntemde, SQL sorgusu kullanılmıştır. Bu sorgu, tüm öğrencilerin verilerini tek bir sorguda döndürür.
 Bu, performans açısından daha iyi bir seçenek olabilir.
  Ancak, döndürülen sonuçlar bir Object[] listesi şeklinde olacaktır.

Yol:
Bu yöntemde, HQL (Hibernate Query Language) sorgusu kullanılmıştır.
 HQL, Hibernate ORM sistemi tarafından kullanılan bir sorgu dili olduğu için daha fazla özellik sunar.
  Bu yöntem, tüm öğrencilerin verilerini tek bir sorguda döndürür. Bu sorgu, Student01 sınıfındaki nesneler şeklinde sonuçlar döndürür.

Genel olarak, performans açısından en iyi seçenek son yöntemdir.
Bu yöntem, tek bir sorgu kullanarak tüm öğrenci verilerini alır ve nesne şeklinde döndürür.
 İkinci yöntemde de tüm öğrenci verileri tek bir sorgu ile alınır,
 ancak sonuçlar bir Object[] listesi şeklinde döndürülür.
 İlk yöntemde ise, her bir öğrenci kaydı için ayrı bir sorgu kullanılarak performans sorunlarına neden olunabilir.

--->>>> burada izlemme gereken yol en az hata alma ihtimali olan yapiyi kullnamak
        yani hazir method varsa kullnamak yani
        birinci yol olarak hazir method get()
        ikinci olarak HQL
        ucuncu olrak SQL

         */

        // Donecek kaydin unique(tek bir kayit) olacagindan emin isem
        // uniqueResult()...
        // --> SQL ile
        String sqlQuery2 = "select * from t_Student where student_name = 'Cemil Bey'"; // hataya acik name yazsam RTE alicam
        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(uniqueResult1));

        // yukaridan  bir obje gelecek ama icinde field'lar oldugu icin bunlari ayri ayri almak istersem;
        System.out.println(uniqueResult1[0]+ " : "+ uniqueResult1[1] + " : " + uniqueResult1[2]);

        //--> HQL ile

        String hglQuery2 = " from Student01 where name= 'Cemil Bey'";
        Student01 uniqueResult2 = session.createQuery(hglQuery2, Student01.class).uniqueResult();
        System.out.println(uniqueResult2);

        // !!! YUKARDAKI sorguyu HQL alias kullanarak yapalim
        String hqlQuery3 = "FROM Student01 std WHERE std.name='Cemil Bey'";
        Student01 uniqueResult3 =session.createQuery(hqlQuery3, Student01.class).uniqueResult();
        System.out.println(uniqueResult3);

        //// !!! HQL ile grade degeri 90 olan ogrenciyi getirelim
        // gelecek datanin tek bir data olacagindan emin degilim o yuzden uniqueResult kullanamam
        //1.Yol
        String hglQuery4 = "select s.id, s.name from Student01 s where s.grade = 90 ";
        List<Objects[]> resultList4 = session.createQuery(hglQuery4).getResultList();
        for (Object[] object: resultList4) {
            System.out.println(Arrays.toString(object));
        }
        //2.Yol: Db'den gelen data nin ne ile eslesecegini bilirsem:
        String hqlQuery5="From Student01 std where std.grade=90";
        List<Student01> Result2=session.createQuery(hqlQuery5,Student01.class).getResultList();
        System.out.println(Result2);


         tx.commit();
         session.clear();
         sf.close();

    }

}
