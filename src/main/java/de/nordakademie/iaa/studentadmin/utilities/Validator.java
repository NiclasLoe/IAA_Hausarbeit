package de.nordakademie.iaa.studentadmin.utilities;

import java.util.Date;

/**
 * Validator class including all validate methods.
 *
 * @author Lennart Meincke
 */
public class Validator {
    /**
     * Validates the e-mail address.
     *
     * @param email The given e-mail address.
     * @return Validation result.
     */
    public static boolean isValidEmail(String email) {
        // It's almost impossible to perfectly check for all RFC822 compliant emails, so before we reject a valid email, we just have a very basic check for @.
        if (email == null || !email.contains("@")) {
            return false;
        }
        return true;
    }

    /**
     * Validates the phone number.
     *
     * @param number The given phone number.
     * @return Validation result.
     */
    public static boolean isValidPhoneNumber(Integer number) {
        if (number == null) {
            return false;
        }

        return isValidPhoneNumber(number.toString());
    }

    /**
     * Validates the phone number.
     *
     * @param number The given phone number.
     * @return Validation result.
     */
    public static boolean isValidPhoneNumber(String number) {
        if (number == null || number.length() == 0 || !number.matches("\\+?[0-9]+")) {
            return false;
        }

        return true;
    }

    /**
     * Validates numbers.
     *
     * @param number The given number.
     * @return Validation result.
     */
    public static boolean isValidNumber(Integer number) {
        if (number == null) {
            return false;
        }

        return isValidNumber(number.toString());
    }

    /**
     * Validates numbers.
     *
     * @param number The given number.
     * @return Validation result.
     */
    public static boolean isValidNumber(String number) {
        if (number == null || number.length() == 0 || !number.matches("[0-9]+")) {
            return false;
        }

        return true;
    }

    /**
     * Validates the date of birth.
     *
     * @param date The given date.
     * @return Validation result.
     */
    public static boolean isValidDate(Date date) {
        if (date != null && date.before(new Date())) {
            return false;
        }

        return true;
    }

    /**
     * Validates whether object is null.
     *
     * @param object The given object.
     * @return Validation result.
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * Validates whether string is empty.
     *
     * @param string The given string.
     * @return Validation result.
     */
    public static boolean isStringEmpty(String string) {
        return isNull(string) || string.trim().length() == 0;
    }
}