package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Supervisor;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;

/**
 * Interface for the supervisor service.
 *
 * @author Lennart Meincke
 */
public interface SupervisorService {
    /**
     * Save a given supervisor entity.
     *
     * @param supervisor The entity to be saved.
     * @return The id of the created entity.
     */
    Long saveSupervisor(Supervisor supervisor);

    /**
     * Load a supervisor by a given id.
     *
     * @param id The given id.
     * @return The found entity.
     */
    Supervisor loadSupervisor(Long id);

    /**
     * Deletes a supervisor from the database.
     *
     * @param supervisorId
     */
    void delete(Long supervisorId) throws EntityNotFoundException;
}
