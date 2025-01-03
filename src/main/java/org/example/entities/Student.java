package org.example.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "studentId")
    private int id;
    @Column(name = "studentName")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "CERTI_STUD",joinColumns = {
//            @JoinColumn(name = "STUDENT_ID_FK")},
//            inverseJoinColumns = {@JoinColumn(name = "CERTI_ID_FK")}
//    )
    private Set<Certification> certifications = new HashSet<>();

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }

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
}
