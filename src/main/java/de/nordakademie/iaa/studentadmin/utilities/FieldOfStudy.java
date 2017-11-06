package de.nordakademie.iaa.studentadmin.utilities;

/**
 * Enum for the field of studies.
 *
 * @author Niclas Loeding
 */
public enum FieldOfStudy {
    AINF("A"), WINF("I"), WING("W"), BWL("B");

    private final String shortForm;

    FieldOfStudy(String shortForm) {
        this.shortForm = shortForm;
    }

    public String getShortForm() {
        return shortForm;
    }
}
