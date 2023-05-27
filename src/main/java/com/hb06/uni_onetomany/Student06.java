package com.hb06.uni_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {

    @Id
    private int id;

    @Column(name="student_name",nullable = false)
    private String name;

    private int grade;

    /*
    Suan iliskiyi One tarafindan kuruyorum ve Many tarafindan gelecek bir yapi var
    suanda kotu bir kodlama yapiyorum

     */

    @OneToMany
    @JoinColumn
    private List<Book06> book06list = new ArrayList<>();


    //Getter Setter

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

    public List<Book06> getBook06list() {
        return book06list;
    }

//    public void setBook06list(List<Book06> book06list) {
//        this.book06list = book06list;
//    }

    //To String


    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", book06list=" + book06list +
                '}';
    }
}
