package de.nordakademie.iaa.studentadmin.utilities;

public class EntityAlreadyPresentException extends Exception {
    public EntityAlreadyPresentException() {
        super();
    }

    public EntityAlreadyPresentException(String message) {
        super(message);
    }
}
