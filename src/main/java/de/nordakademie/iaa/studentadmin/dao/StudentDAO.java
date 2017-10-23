package de.nordakademie.iaa.studentadmin.dao;

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
        return (Student) entityManager
                .createQuery("SELECT student FROM Student student WHERE (student.id= :id)")
                .setParameter("id", id)
                .getSingleResult();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Long countEntries() {
        Long count = (Long) entityManager.createQuery("SELECT count(student) FROM Student student").getSingleResult();
        return count;
    }
}
