package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import de.nordakademie.iaa.studentadmin.utilities.Status;
import de.nordakademie.iaa.studentadmin.model.Student;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Long countEntries(Status status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(root);

        if (status != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("status"), status));
        }

        TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
        List<Student> queryResult = query.getResultList();

        Long count = (long) queryResult.size();
        return count;
    }

    public List<Student> findStudents(Status status, Century century, FieldOfStudy fieldOfStudy, Integer year, String userMail) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(root);

        if (status != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("status"), status));
        }
        if (century != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("century"), century));
        }
        if (fieldOfStudy != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("century").get("fieldOfStudy"), fieldOfStudy));
        }
        if (year != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("century").get("year"), year));
        }
        if (userMail != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("userEmail"), userMail));
        }

        TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
        List<Student> queryResult = query.getResultList();

        return queryResult;
    }

    public void saveStudent(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }
    }

    public Student load(long id) {
        return entityManager.find(Student.class, id);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
