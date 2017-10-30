package de.nordakademie.iaa.studentadmin.model;

import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import de.nordakademie.iaa.studentadmin.utilities.Status;

import javax.persistence.*;

@Entity
public class Student extends Person {

    private Status status;
    private Integer studentId;
    @ManyToOne
    @JoinColumn
    private Company company;
    @ManyToOne
    private Century century;
    private Integer username;
    private String userEmail;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Century getCentury() {
        return century;
    }

    public void setCentury(Century century) {
        this.century = century;
    }

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
