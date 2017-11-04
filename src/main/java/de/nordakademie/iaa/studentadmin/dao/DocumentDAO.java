package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Document;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class DocumentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Saves the given picture into the database.
     *
     * @param profilePicture The profile picture to be saved.
     */
    public Long save(Document document) {
        if (document.getId() == null) {
            entityManager.persist(document);
        } else {
            entityManager.merge(document);
        }
        return document.getId();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Document loadById(Long id) {
        return entityManager.find(Document.class, id);
    }
}
