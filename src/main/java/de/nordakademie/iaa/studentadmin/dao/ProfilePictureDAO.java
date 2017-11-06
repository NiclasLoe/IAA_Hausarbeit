package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.ProfilePicture;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ProfilePictureDAO {

    /**
     * The current entity manager.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Saves the given picture into the database.
     *
     * @param profilePicture The profile picture to be saved.
     */
    public Long save(ProfilePicture profilePicture) {
        if (profilePicture.getId() == null) {
            entityManager.persist(profilePicture);
        } else {
            entityManager.merge(profilePicture);
        }
        return profilePicture.getId();
    }

    /**
     * Load a picture by a given identifier.
     *
     * @param photoId The profile picture's identifier.
     * @return The found entity.
     */
    public ProfilePicture loadById(Long photoId) {
        return entityManager.find(ProfilePicture.class, photoId);
    }

    /**
     * Delete a profile picutre from the database.
     *
     * @param profilePicture The given profile picture.
     */
    public void delete(ProfilePicture profilePicture) {
        entityManager.remove(profilePicture);
    }

    // Getter and setter

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
