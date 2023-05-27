package com.hb05.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

  /*
    uni-direction Many-to-One RelationShip

    university -  Student06
      one            Many

      iliskinin nerede olacagina ben karar veriyorum. JOinCoulm nerede yazicam yani iliski sahibi hangi taraf olsun?
      Student06'dan uni ye ulasmak daha kolay uni_id diye colum olusturmak cunku bir Ogrenci birden fazla uni ye sahip olmaz
      ama uni birden fazla ogr. sahip olacagindan std_id universite
      tablosunda column olusturursam list yapsini kullnamak zorunda kalicam.

     */


@Entity
public class University {

    @Id
    private int id;

    @Column(nullable = false, unique = true )
    private String name;

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

    @Override
    public String toString() {
        return "Unuversity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
