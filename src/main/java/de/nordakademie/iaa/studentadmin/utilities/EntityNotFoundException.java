package de.nordakademie.iaa.studentadmin.utilities;

/**
 * Exception thrown in case entity cannot be found.
 *
 * @author Niclas Loeding
 */
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
