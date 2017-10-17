package de.nordakademie.iaa.studentadmin.model;

import javax.persistence.Entity;

@Entity
public class Student extends Person {

    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
