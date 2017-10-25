package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Company;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CompanyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Company> listAll() {
        return entityManager.createQuery("SELECT company FROM Company company").getResultList();
    }

    public Company loadByID(Long companyId) {
        return entityManager.find(Company.class, companyId);
    }
}
