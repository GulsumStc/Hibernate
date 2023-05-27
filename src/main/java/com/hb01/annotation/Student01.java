package com.hb01.annotation;


import javax.persistence.*;

@Entity //!!! @Entity ile bu sinifin DB de bir tabbloya karsilik gelmesini sagliyoruz, student01
@Table(name="t_student01") //!!! DB de tablo isminin "t_student01" olarak degismesini sagladim

//Java kodu icinde bu clasa ulasirken  Student01 ile SQL ile ulasirken t_student01 ile yazamam lazim.
public class Student01 {

    @Id // Primary- key olusmasini sagliyoruz -->  altindaki ilk degiskene kendini kitler
   // @Column(name = "std_id")
    private int id;

    //name fieldinin database deki adını ve özelliğini belirliyoruz
    @Column(name="student_name", length = 100, nullable = false, unique = true)
    private String name;


    // burada grad'in tablo ile iliskilendirilmesini istemiyorsam;
    //@Transient // DB'deki tabloda column olusmaini engelliyor...
    private int grade;

    @Lob // large object ile database de buyuk boyutlu datalar tutulabiliyor.
    //private byte[] image;


    // !!! GETTER - SETTER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // !!! toString()

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }



}
