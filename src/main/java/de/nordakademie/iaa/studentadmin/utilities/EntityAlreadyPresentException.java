package de.nordakademie.iaa.studentadmin.utilities;

/**
 * Exception thrown in case entity is already present.
 *
 * @author Niclas Loeding
 */
public class EntityAlreadyPresentException extends Exception {
    public EntityAlreadyPresentException() {
        super();
    }

    public EntityAlreadyPresentException(String message) {
        super(message);
    }
}
