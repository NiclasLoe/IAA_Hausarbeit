package de.nordakademie.iaa.studentadmin.utilities;

import com.opensymphony.xwork2.ActionSupport;

public class ActionSupportValidator {
    private ActionSupport actionSupport;

    public ActionSupportValidator(ActionSupport actionSupport) {
        this.actionSupport = actionSupport;
    }

    public void fieldValidated(boolean value, String fieldName, String errorMessage) {
        if (value) {
            actionSupport.addFieldError(fieldName, errorMessage);
        }
    }
}