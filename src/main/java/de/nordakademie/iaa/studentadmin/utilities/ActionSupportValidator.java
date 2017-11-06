package de.nordakademie.iaa.studentadmin.utilities;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Validator class.
 *
 * @author Lennart Meincke
 */
public class ActionSupportValidator {
    /**
     * The action support.
     */
    private ActionSupport actionSupport;

    /**
     * Constructor.
     *
     * @param actionSupport The action support.
     */
    public ActionSupportValidator(ActionSupport actionSupport) {
        this.actionSupport = actionSupport;
    }

    /**
     * Method to add a field error.
     *
     * @param value Value of the check.
     * @param fieldName Name of the checked field.
     * @param errorMessage Error message.
     */
    public void fieldValidated(boolean value, String fieldName, String errorMessage) {
        if (value) {
            actionSupport.addFieldError(fieldName, errorMessage);
        }
    }


}