package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Person;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ApplicantDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAll() {
        return entityManager.createQuery("SELECT APPLICANT FROM Applicant APPLICANT").getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Long countEntries() {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(APPLICANT) FROM Applicant APPLICANT").getSingleResult();
        return count;
    }

    public Applicant load(long id) {
        return entityManager.find(Applicant.class, id);
    }

    public void save(Applicant applicant) {
        if (applicant.getId() == null) {
            entityManager.persist(applicant);
        } else {
            entityManager.merge(applicant);
        }
    }

    public void delete(Applicant applicant) {
        entityManager.remove(applicant);
    }
}


