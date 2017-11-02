package de.nordakademie.iaa.studentadmin.model;

import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Applicant entity.
 *
 * @author Niclas Loeding
 */
@Entity
public class Applicant extends Person {

    /**
     * The field of study.
     */
    @Column(nullable = false)
    private FieldOfStudy fieldOfStudy;

    public FieldOfStudy getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
}
