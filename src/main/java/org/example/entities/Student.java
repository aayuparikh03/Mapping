package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id @GeneratedValue @Column(name = "STUDENT_ID")
    private int id;
    @Column(name = "STUDENT_NAME")
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DETAILED_FK")
    private StudentDetails studentDetails;

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
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
