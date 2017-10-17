package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class ApplicantDAO {

    private EntityManager entityManager;

    public List<Person> findAll() {
        //return entityManager.createQuery("SELECT applicant FROM APPLICANT applicant").getResultList();
        return null;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}


