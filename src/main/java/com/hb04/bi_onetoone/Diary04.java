package com.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
public class Diary04 {

    @Id
    private int id;


    private String name;

     /*
    Bi direction One to One Mapping (cift tarafli iliski)
    Diary icinde student objemi olusturuyorum. Student icinde diary objesini olusturuyorum
    iliski cift tarafli
    mappedBy: iliski sahibini belirlememe yariyor. mappedBy'ya atanan field nerede ise o tablo islikinin sahibidir.
    Bi direction uni direction ile tek farki sttudent classida da iliski kulurulan tablonun field'i var
     */


    @OneToOne
    @JoinColumn(name="std_id")
    private Student04 student;

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

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary04{" +
                "id=" + id +
                ", name='" + name + '\'' +
               /* ", student=" + student + */   // --> StacOverFlow
                '}';
    }
}
