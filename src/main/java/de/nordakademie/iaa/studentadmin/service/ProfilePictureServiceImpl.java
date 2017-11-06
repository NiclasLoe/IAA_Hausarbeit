package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.ProfilePictureDAO;
import de.nordakademie.iaa.studentadmin.model.ProfilePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Component
public class ProfilePictureServiceImpl implements ProfilePictureService {

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
}

