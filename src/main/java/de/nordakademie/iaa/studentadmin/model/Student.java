package de.nordakademie.iaa.studentadmin.model;

import de.nordakademie.iaa.studentadmin.utilities.Status;

import javax.persistence.*;

/**
 * Student entity.
 *
 * @author Niclas Loeding
 */
@Entity
public class Student extends Person {

    /**
     * The status.
     */
    @Column(name = "STATUS", nullable = false)
    private Status status;
    /**
     * The student id.
     */
    @Column(name = "STUDENT_ID", nullable = false)
    private Integer studentId;
    /**
     * The company.
     */
    @Column(name = "COMPANY", nullable = false)
    @ManyToOne
    @JoinColumn
    private Company company;
    /**
     * The century.
     */
    @Column(name = "CENTURY", nullable = false)
    @ManyToOne
    private Century century;
    /**
     * The username
     */
    @Column(name = "USERNAME", nullable = false)
    private Integer username;
    /**
     * The user email address.
     */
    @Column(name = "USER_EMAIL", nullable = false)
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
