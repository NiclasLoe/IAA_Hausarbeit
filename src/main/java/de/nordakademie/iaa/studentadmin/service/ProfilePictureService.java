package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.ProfilePicture;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;

/**
 * Interface for the profile picture service.
 *
 * @author Niclas Loeding
 */
public interface ProfilePictureService {

    /**
     * Load profile picture by its identifier.
     *
     * @param photoId The given identifier.
     * @return The found entity.
     */
    ProfilePicture loadImage(Long photoId);

    /**
     * Save new profile picture.
     *
     * @param fileContent The given content of the profile picture.
     * @return The profile picture's identifier.
     */
    Long saveNewImage(byte[] fileContent);

    /**
     * Delete image from database.
     *
     * @param picId The given identifier.
     * @throws EntityNotFoundException Exception in case image is no longer available.
     */
    void deleteImage(Long picId) throws EntityNotFoundException;
}
