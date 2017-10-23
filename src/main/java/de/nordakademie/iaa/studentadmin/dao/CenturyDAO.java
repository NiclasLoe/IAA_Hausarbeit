package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Century;
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
}
