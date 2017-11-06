package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.utilities.EntityAlreadyPresentException;

import java.util.List;

/**
 * Interface for the century service.
 *
 * @author Niclas Loeding
 */
public interface CenturyService {

    /**
     * List all centuries.
     *
     * @return List of centuries.
     */
    List<Century> listCenturies();

    /**
     * Convert string into century identifier.
     *
     * @param centuryString The century's identifier as string.
     * @return The converted century id.
     */
    CenturyId returnId(String centuryString);

    /**
     * Load a century by identifier.
     *
     * @param centuryId The century's identifier.
     * @return The found entity.
     */
    Century loadCentury(CenturyId centuryId);

    /**
     * Save a century.
     *
     * @param century The given century.
     * @exception EntityAlreadyPresentException Exception in case century is already present.
     */
    void saveCentury(Century century) throws EntityAlreadyPresentException;
}
