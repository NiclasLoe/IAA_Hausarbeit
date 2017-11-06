package de.nordakademie.iaa.studentadmin.utilities;

public enum FieldOfStudy {
    AINF("A"), WINF("I"), WING("W"), BWL("B");

    private String shortForm;

    FieldOfStudy(String shortForm) {
        this.shortForm = shortForm;
    }

    public String getShortForm() {
        return shortForm;
    }
}
