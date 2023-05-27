package com.hb09.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student09 {

    @Id
    private int id;

    @Column(name="student_name", nullable = false)
    private String name;

    private int grade;

    // Cascade den dolayi @OneToMany iliskinin kurulabilmesi icin her iki entity class uzerinden
    // setleme islemi yapmamiz gerekir, eger yapmazsak @JoinColum ile eklenen kolon null degerler ile dolar

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL /*,fetch = FetchType.EAGER*/)// yani setleme islemi book tarafindan olacak diyorum
    private List<Book09> bookList = new ArrayList<>();

    //Getter setter


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

    public List<Book09> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book09> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", book09List=" + bookList +
                '}';
    }



}
