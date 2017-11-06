package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.ProfilePicture;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;

public interface ProfilePictureService {

    ProfilePicture loadImage(Long photoId);

    Long saveNewImage(byte[] fileContent);

    void deleteImage(Long picId) throws EntityNotFoundException;
}
