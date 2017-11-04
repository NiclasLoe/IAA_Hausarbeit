package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.ProfilePicture;

import java.io.FileInputStream;

public interface ProfilePictureService {

    ProfilePicture loadImage(Long photoId);

    Long saveNewImage(byte[] fileContent);
}
