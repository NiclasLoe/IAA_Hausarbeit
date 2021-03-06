package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Company;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * DAO class for companies.
 *
 * @author Niclas Loeding
 */
@Component
public class CompanyDAO {

    /**
     * The current entity manager.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * List all available companies.
     *
     * @return The list of companies.
     */
    public List<Company> listAll() {
        // Create new query
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
        Root<Company> root = criteriaQuery.from(Company.class);
        criteriaQuery.select(root);

        // Get list from query
        TypedQuery<Company> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    /**
     * Load company by a given identifier.
     *
     * @param companyId The company's identifier.
     * @return The found entity.
     */
    public Company loadByID(Long companyId) {
        return entityManager.find(Company.class, companyId);
    }

    /**
     * Save a given company into the database.
     *
     * @param company The company to be saved.
     */
    public void save(Company company) {
        if (company.getId() == null) {
            entityManager.persist(company);
        } else {
            entityManager.merge(company);
        }
    }

    // Getter and setter

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
