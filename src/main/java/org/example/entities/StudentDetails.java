package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class StudentDetails {
    @Id
    @GeneratedValue
    @Column(name = "DETAILS_ID")
    int studentDetailsid;
    @Column(name = "ZIPCODE")
    int zipcode;

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
