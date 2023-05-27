package com.hb09.fetchtypes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book09 {

    @Id
    private int id;

    private String name ;

    @ManyToOne
    @JoinColumn // burasi many tarafi one tarafindan bir tanae data gelecek column'nu burda olusturuyorum
                // ben burad olusturmasamda database burda olusur.
    private Student09 student;

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

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
