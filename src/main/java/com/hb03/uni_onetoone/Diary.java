package com.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {

    @Id
    private int id;

    private String name;

    /*
    uni direction One to One Mapping (Tek tarafli iliski)
    Diary icinde student objemi olusturuyorum.  burada diary uzerinden Student06'a ulasabiliyorum...


     */



    @OneToOne
    @JoinColumn(name="std_id") // iliski sahibi
    private Student03 student;


    // getter and setter

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student03=" + student +
                '}';
    }


}
