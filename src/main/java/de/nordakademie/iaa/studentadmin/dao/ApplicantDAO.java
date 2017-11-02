package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Applicant;
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

/**
 * DAO class for applicants.
 *
 * @author Niclas Loeding
 */
@Component
public class ApplicantDAO {

    /**
     * The current entity manager.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Counts the number of applicants that are stored in the database.
     *
     * @return Number count of applicants stored in database.
     */
    public Long countEntries() {
        List<Applicant> applicants = findApplicants(null, null, null);
        return (long) applicants.size();
    }

    /**
     * Returns the applicant identified by the given id.
     *
     * @param id the applicant's identifier.
     * @return the found entity.
     */
    public Applicant load(long id) {
        return entityManager.find(Applicant.class, id);
    }

    /**
     * Store the given applicant into the database.
     *
     * @param applicant The applicant to be saved.
     */
    public void save(Applicant applicant) {
        if (applicant.getId() == null) {
            entityManager.persist(applicant);
        } else {
            entityManager.merge(applicant);
        }
    }

    /**
     * Removes the given applicant from the database.
     *
     * @param applicant The applicant to be deleted.
     */
    public void delete(Applicant applicant) {
        entityManager.remove(applicant);
    }

    /**
     * Loads a list of applicants that match the input parameters.
     *
     * @param firstName String input for the first name field.
     * @param lastName String input for the last name field.
     * @param fieldOfStudy Field of Study input.
     * @return List of applicants.
     */
    public List<Applicant> findApplicants(String firstName, String lastName, FieldOfStudy fieldOfStudy) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Applicant> criteriaQuery = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> root = criteriaQuery.from(Applicant.class);
        criteriaQuery.select(root);

        // Create criteria for the query
        List<Predicate> predicates = new ArrayList<>();
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

        // Get applicant list
        TypedQuery<Applicant> query = entityManager.createQuery(criteriaQuery);
        List<Applicant> queryResult = query.getResultList();

        return queryResult;
    }

    // Getter and setter

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}


