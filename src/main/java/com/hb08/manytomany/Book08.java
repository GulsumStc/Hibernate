package com.hb08.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book08 {

    @Id
    private int id;

    private String name ;


    // iliski many tarafindan kurulacagindan iki taraf ta many oldugundan butarafi sectim.
    @ManyToMany(mappedBy = "bookList") //--> bookList field'i kimde ise iliski sahibi o diyorum.
                                        // ve burda bir column daha olusmasini engelliyorum.
    private List<Student08> studentList = new ArrayList<>();

    //!!!  Getter and Setter

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

    public List<Student08> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student08> studentList) {
        this.studentList = studentList;
    }


    @Override
    public String toString() {
        return "Book08{" +
                "id=" + id +
                ", name='" + name + '\'' +
              //  ", studentList=" + studentList +  --> infinitive loop'a girmesin diye kaldiriyorum
                '}';
    }
}
