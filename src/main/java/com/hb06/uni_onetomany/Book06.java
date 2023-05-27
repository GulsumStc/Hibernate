package com.hb06.uni_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book06 {


    /*

    Id gibi degisknler de genelde wrapper class kullnilir burda amac: primitive (datalarin default degerinin oldugundan)
    default degeri atanmasini istemedigimden genelde Wrapper class kullnilir.

    */

    @Id
    private int id;


    private String name;

    // getter ve setter


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

    //NOte: iliski tek tarafli oldugundan infinitive loop olma gibi bir durum soz konusu degil
    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
