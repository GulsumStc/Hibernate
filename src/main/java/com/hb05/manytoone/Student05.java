package com.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student05 {

    @Id
    private int id;


    @Column(name="std_name",nullable = false)
    private String name;

    private int grade;


    private LocalDateTime createOn;


    /*

    uni-Direction yani tek tarafli bir iliski kuruyorum suanda
    sadece Student06'tan Uni ye ulasabiliyorum. uni'den Studenta ulasamam.


    Bir Objenin create edilmesi ile persist edilmesi arasındaki farklar:

    Create Edilmesi ==> Biz new'lediğimiz anda o obje yazılımsal olarak oluşur ama programı kapattığımız anda silinir.
    Bizim bunu persist edebilmemiz için farklı yöntemler var; 1)Harddisk'e yazmak, 2)Database'e yazmak, 3)Remote bir yere göndermek.
    Biz bu üç yöntemden biri gerçekleştiği(kalıcı/persist olduğu) anki tarihi istiyorsak eğer "@PrePersist" annotation'ını kullanırız */

    @ManyToOne // Student06 classi many y' temsil ettiginden manytoone yazariz
                // uni kisminda olsak onetomany yazardik
    @JoinColumn(name="university_id") // Student06 tabloma stun ekelenecek iliski sahibi Student06
    private University university;

    @PrePersist  //Students objesinin persist edilme zamamnini createOn degiskenine atiyoruz.
                 // Ogrenci objesinin db ye gittigi ani kalici hale getirir bu durumda set methoduna gerek yok
    public void prePersist(){
        createOn=LocalDateTime.now();
    }    // yada final yaparsak (CreateOn ) islem hallonurdu

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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", unuversity=" + university +
                '}';
    }
}
