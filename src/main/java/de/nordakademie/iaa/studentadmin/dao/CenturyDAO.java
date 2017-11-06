package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        // Create new query
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Century> criteriaQuery = criteriaBuilder.createQuery(Century.class);
        Root<Century> root = criteriaQuery.from(Century.class);
        criteriaQuery.select(root);

        // Get list from query
        TypedQuery<Century> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    /**
     * Load the century with a given identifier.
     *
     * @param centuryId The century's identifier.
     * @return The found entity.
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
