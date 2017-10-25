package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.model.CenturyId;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CenturyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Century> listAll() {
        return entityManager.createQuery("SELECT c FROM Century c").getResultList();
    }

    public Century load(CenturyId centuryId) {
        return entityManager.find(Century.class, centuryId);
    }

    public void save(Century century) {
        entityManager.persist(century);
    }
}
