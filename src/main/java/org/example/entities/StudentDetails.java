package org.example.entities;

import jakarta.persistence.*;

@Entity
public class StudentDetails {
    @Id
    @GeneratedValue
    @Column(name = "DETAILS_ID")
    int studentDetailsid;
    @Column(name = "ZIPCODE")
    int zipcode;
    @OneToOne(mappedBy = "studentDetails", cascade = CascadeType.ALL)
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getStudentDetailsid() {
        return studentDetailsid;
    }

    public void setStudentDetailsid(int studentDetailsid) {
        this.studentDetailsid = studentDetailsid;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
