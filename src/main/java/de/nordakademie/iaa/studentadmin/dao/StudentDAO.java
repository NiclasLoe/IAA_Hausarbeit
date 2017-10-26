package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.model.FieldOfStudy;
import de.nordakademie.iaa.studentadmin.model.Status;
import de.nordakademie.iaa.studentadmin.model.Student;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> findStudents(Status status) {
        return entityManager
                .createQuery("SELECT student FROM Student student WHERE (student.status= :status)")
                .setParameter("status", status)
                .getResultList();
    }

    public Long countEntriesByStatus(Status status) {
        Long count = (Long) entityManager
                .createQuery("SELECT COUNT(student) FROM Student student WHERE (student.status= :status)")
                .setParameter("status", status)
                .getSingleResult();
        return count;
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

    public List<Student> findStudentsByCentury(Century century) {
        return entityManager
                .createQuery("SELECT s FROM Student s WHERE s.century= :century")
                .setParameter("century", century)
                .getResultList();
    }

    public List<Student> findStudentsByManiple(FieldOfStudy fieldOfStudy, Integer year) {
        return entityManager
                .createQuery("SELECT s FROM Student s WHERE s.century.fieldOfStudy = :fos and s.century.year = :year")
                .setParameter("fos", fieldOfStudy)
                .setParameter("year", year)
                .getResultList();
    }
}
