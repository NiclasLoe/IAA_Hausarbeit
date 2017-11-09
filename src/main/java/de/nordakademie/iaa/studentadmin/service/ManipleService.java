package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

import java.util.List;

/**
 * Interface for the maniple service.
 *
 * @author Lennart Meincke
 */
public interface ManipleService {

    /**
     * Load all available maniple.
     *
     * @return List of maniple names.
     */
    List<String> getAvailableManiple();

    /**
     * Convert maniple string to field of study.
     *
     * @param maniple The maniple name as string.
     * @return The related field of study.
     */
    FieldOfStudy returnFieldOfStudy(String maniple);

    /**
     * Convert maniple string to year.
     *
     * @param maniple The maniple name as string.
     * @return The related year.
     */
    Integer returnYear(String maniple);
}
