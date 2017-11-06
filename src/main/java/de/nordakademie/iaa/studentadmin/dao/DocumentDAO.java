package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.Document;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class DocumentDAO {

    /**
     * The current entity manager.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Saves the given picture into the database.
     *
     * @param document The document to be saved.
     */
    public Long save(Document document) {
        if (document.getId() == null) {
            entityManager.persist(document);
        } else {
            entityManager.merge(document);
        }
        return document.getId();
    }

    /**
     * Load a document.
     *
     * @param id The document's identifier.
     * @return The found entity.
     */
    public Document loadById(Long id) {
        return entityManager.find(Document.class, id);
    }

    /**
     * Delete a document from the database.
     *
     * @param document Document to be deleted.
     */
    public void delete(Document document) {
        entityManager.remove(document);
    }

    // Getter and setter

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
