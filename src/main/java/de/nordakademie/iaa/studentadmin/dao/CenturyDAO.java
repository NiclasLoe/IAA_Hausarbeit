package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * DAO class for the century.
 *
 * @author Niclas Loeding
 */
@Component
public class CenturyDAO {

    /**
     * The current entity manager.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Load all centuries from the database.
     *
     * @return List of all centuries.
     */
    public List<Century> listAll() {
        return entityManager.createQuery("SELECT c FROM Century c").getResultList();
    }

    /**
     * Load the century with a given identifier.
     *
     * @param centuryId The century's identifier.
     * @return The found entitiy.
     */
    public Century load(CenturyId centuryId) {
        return entityManager.find(Century.class, centuryId);
    }

    /**
     * Save a given century into the database.
     *
     * @param century The century to be saved.
     */
    public void save(Century century) {
        entityManager.persist(century);
    }

    // Getter and setter

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
