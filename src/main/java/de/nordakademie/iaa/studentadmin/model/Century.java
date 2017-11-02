package de.nordakademie.iaa.studentadmin.model;

import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

import javax.persistence.*;

/**
 * Century entity.
 *
 * @author Niclas Loeding
 */
@Entity
@IdClass(CenturyId.class)
public class Century {

    /**
     * The field of study and part of the id.
     */
    @Id
    @Column(nullable = false, length = 4, name = "FIELD_OF_STUDY")
    private FieldOfStudy fieldOfStudy;
    /**
     * The year and part of the id.
     */
    @Id
    @Column(nullable = false, length = 2)
    private Integer year;
    /**
     * The letter code and part of the id.
     */
    @Id
    @Column(nullable = false, length = 1, name = "LETTER_CODE")
    private String letterCode;
    /**
     *
     */
    @Transient
    private String centuryName;

    public FieldOfStudy getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLetterCode() {
        return letterCode;
    }

    public void setLetterCode(String letterCode) {
        this.letterCode = letterCode;
    }

    /**
     * Generates the name of the century by its id.
     *
     * @return Name of the century.
     */
    public String getCenturyName() {
        String yearString = "" + year;
        yearString = yearString.substring(2, 4);
        centuryName = fieldOfStudy.getShortForm() + yearString + letterCode;
        return centuryName;
    }

    public void setCenturyName(String centuryName) {
        this.centuryName = centuryName;
    }
}
