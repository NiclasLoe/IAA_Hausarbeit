package de.nordakademie.iaa.studentadmin.model;

public enum FieldOfStudy {
    AINF("A"), WINF("I"), WING("W"), BWL("B");

    private String shortForm;

    private FieldOfStudy(String shortForm) {
        this.shortForm = shortForm;
    }

    public String getShortForm() {
        return shortForm;
    }
}
