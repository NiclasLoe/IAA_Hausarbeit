package de.nordakademie.iaa.studentadmin.dao;

import de.nordakademie.iaa.studentadmin.model.ProfilePicture;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ProfilePictureDAO {

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

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ProfilePicture loadById(Long photoId) {
        return entityManager.find(ProfilePicture.class, photoId);
    }
}
