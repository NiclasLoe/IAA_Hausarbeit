package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import de.nordakademie.iaa.studentadmin.utilities.Status;
import de.nordakademie.iaa.studentadmin.model.Student;
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
 * DAO class for students.
 *
 * @author Niclas Loeding
 */
@Component
public class StudentDAO {

    /**
     * The current entity manager.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Method that counts the students with a given status.
     *
     * @param status Status input for query.
     * @return number of students with that status.
     */
    public Long countEntries(Status status) {
        List<Student> students = findStudents(status, null, null, null,
                null, null, null,
                null, null);
        return (long) students.size();
    }

    /**
     * Method to create a query with several parameters.
     *
     * @param status       Status input.
     * @param century      Century input.
     * @param fieldOfStudy Field of Study input.
     * @param year         Year input.
     * @param userMail     UserMail input.
     * @param company      Company input.
     * @param firstName    First name input.
     * @param lastName     Last name input.
     * @param studentId    Student id input.
     * @return List of students that match the criteria.
     */
    public List<Student> findStudents(Status status, Century century, FieldOfStudy fieldOfStudy, Integer year,
                                      String userMail, Company company, String firstName,
                                      String lastName, Integer studentId) {
        // Create new query
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(root);

        // Build criteria list
        List<Predicate> predicates = new ArrayList<>();
        if (status != null) {
            predicates.add(criteriaBuilder.equal(root.get("status"), status));
        }
        if (century != null) {
            predicates.add(criteriaBuilder.equal(root.get("century"), century));
        }
        if (fieldOfStudy != null) {
            predicates.add(criteriaBuilder.equal(root.get("century").get("fieldOfStudy"), fieldOfStudy));
        }
        if (year != null) {
            predicates.add(criteriaBuilder.equal(root.get("century").get("year"), year));
        }
        if (userMail != null) {
            predicates.add(criteriaBuilder.equal(root.get("userEmail"), userMail));
        }
        if (company != null) {
            predicates.add(criteriaBuilder.equal(root.get("company"), company));
        }
        if (firstName != null) {
            predicates.add(criteriaBuilder.equal(root.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(criteriaBuilder.equal(root.get("lastName"), lastName));
        }
        if (studentId != null) {
            predicates.add(criteriaBuilder.equal(root.get("studentId"), studentId));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));

        // Get list from query
        TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    /**
     * Method to save a given student.
     *
     * @param student The student to be saved.
     */
    public void saveStudent(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }
    }

    /**
     * Method to load a student with a given id.
     *
     * @param id The student's identifier.
     * @return the found entity.
     */
    public Student load(long id) {
        return entityManager.find(Student.class, id);
    }

    // Getter and setter

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
