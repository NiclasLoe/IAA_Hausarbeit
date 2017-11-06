package de.nordakademie.iaa.studentadmin.utilities;

import java.util.Date;

public class Validator {
    public static boolean isValidEmail(String email) {
        // It's almost impossible to perfectly check for all RFC822 compliant emails, so before we reject a valid email, we just have a very basic check for @.
        if (email == null || !email.contains("@")) {
            return false;
        }
        return true;
    }

    public static boolean isValidPhoneNumber(Integer number) {
        if (number == null) {
            return false;
        }

        return isValidPhoneNumber(number.toString());
    }

    public static boolean isValidPhoneNumber(String number) {
        if (number == null || number.length() == 0 || !number.matches("\\+?[0-9]+")) {
            return false;
        }

        return true;
    }

    public static boolean isValidNumber(Integer number) {
        if (number == null) {
            return false;
        }

        return isValidNumber(number.toString());
    }

    public static boolean isValidNumber(String number) {
        if (number == null || number.length() == 0 || !number.matches("[0-9]+")) {
            return false;
        }

        return true;
    }

    public static boolean isValidDate(Date date) {
        if (date != null && date.before(new Date())) {
            return false;
        }

        return true;
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isStringEmpty(String string) {
        return isNull(string) || string.trim().length() == 0;
    }
}