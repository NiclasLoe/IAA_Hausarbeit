package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Supervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The DAO class for the supervisor.
 *
 * @author Niclas Loeding
 */
@Component
public class SupervisorDAO {

    /**
     * The current entity manager.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Method to save a given supervisor into the database.
     *
     * @param supervisor The supervisor to be saved.
     * @return The id of the supervisor.
     */
    public Long save(Supervisor supervisor) {
        if (supervisor.getId() == null) {
            entityManager.persist(supervisor);
        } else {
            entityManager.merge(supervisor);
        }
        return supervisor.getId();
    }

    /**
     * Load a supervisor by a given id.
     *
     * @param id The supervisors identifier.
     * @return The found entity.
     */
    public Supervisor load(Long id) {
        return entityManager.find(Supervisor.class, id);
    }

    /**
     * Delete a supervisor from the database.
     *
     * @param supervisor The supervisor to be deleted.
     */
    public void delete(Supervisor supervisor) {
        entityManager.remove(supervisor);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
