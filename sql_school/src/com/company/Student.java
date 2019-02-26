package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private Integer fee;
    private List<Oceny> listaOcenStudent;

    public Student(Integer id, String firstName, String lastName, Date dob, String email, Integer fee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public List<Oceny> getListaOcenStudent() {
        return listaOcenStudent;
    }

    public void setListaOcenStudent(List<Oceny> listaOcenStudent) {
        this.listaOcenStudent = listaOcenStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fee=" + fee +
                ", listaOcenStudent=" + listaOcenStudent +
                '}';
    }
}
