package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Person;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicantDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Long countEntries() {
        List<Applicant> applicants = findApplicants(null, null, null);
        return (long) applicants.size();
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

    public List<Applicant> findApplicants(String firstName, String lastName, FieldOfStudy fieldOfStudy) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Applicant> criteriaQuery = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> root = criteriaQuery.from(Applicant.class);
        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.select(root);

        if (fieldOfStudy != null) {
            predicates.add(criteriaBuilder.equal(root.get("fieldOfStudy"), fieldOfStudy));
        }
        if (firstName != null) {
            predicates.add(criteriaBuilder.equal(root.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(criteriaBuilder.equal(root.get("lastName"), lastName));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Applicant> query = entityManager.createQuery(criteriaQuery);
        List<Applicant> queryResult = query.getResultList();

        return queryResult;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}


