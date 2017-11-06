package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.ProfilePictureDAO;
import de.nordakademie.iaa.studentadmin.model.ProfilePicture;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Profile picture service implementation.
 *
 * @author Niclas Loeding
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Component
public class ProfilePictureServiceImpl implements ProfilePictureService {

    /**
     * The profile picture DAO.
     */
    @Autowired
    private ProfilePictureDAO profilePictureDAO;

    @Override
    public Long saveNewImage(byte[] fileContent) {
        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setImage(fileContent);
        return profilePictureDAO.save(profilePicture);
    }

    @Override
    public ProfilePicture loadImage(Long photoId) {
        return profilePictureDAO.loadById(photoId);
    }

    @Override
    public void deleteImage(Long picId) throws EntityNotFoundException {
        ProfilePicture profilePicture = loadImage(picId);
        if (profilePicture == null) {
            throw new EntityNotFoundException();
        } else {
            profilePictureDAO.delete(profilePicture);
        }
    }
}

