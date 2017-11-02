package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Company;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return entityManager.createQuery("SELECT company FROM Company company").getResultList();
    }

    public Company loadByID(Long companyId) {
        return entityManager.find(Company.class, companyId);
    }

    public void save(Company company) {
        if (company.getId() == null) {
            entityManager.persist(company);
        } else {
            entityManager.merge(company);
        }
    }
}
