package de.nordakademie.iaa.studentadmin.utilities;

import java.io.Serializable;

public class CenturyId implements Serializable {

    private Integer year;
    private String letterCode;
    private FieldOfStudy fieldOfStudy;

    public CenturyId() {
    }

    public CenturyId(Integer year, String letterCode, FieldOfStudy fieldOfStudy) {
        this.year = year;
        this.letterCode = letterCode;
        this.fieldOfStudy = fieldOfStudy;
    }

    public Integer getYear() {
        return year;
    }

    public String getLetterCode() {
        return letterCode;
    }

    public FieldOfStudy getFieldOfStudy() {
        return fieldOfStudy;
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result
                + ((fieldOfStudy == null) ? 0 : fieldOfStudy.hashCode())
                + ((letterCode == null) ? 0 : letterCode.hashCode());
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CenturyId other = (CenturyId) obj;
        if (fieldOfStudy == null) {
            if (other.fieldOfStudy != null)
                return false;
        } else if (!fieldOfStudy.equals(other.fieldOfStudy))
            return false;
        if (!year.equals(other.year))
            return false;
        if (letterCode == null) {
            if (other.letterCode != null)
                return false;
        } else if (!letterCode.equals(other.letterCode))
            return false;
        return true;
    }
}
