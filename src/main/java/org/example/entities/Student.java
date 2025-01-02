package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private int id;
    @Column(name = "STUDENT_NAME")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COLLEGE_FK")
    private StudentCollege studentCollege;

    public StudentCollege getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(StudentCollege studentCollege) {
        this.studentCollege = studentCollege;
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
