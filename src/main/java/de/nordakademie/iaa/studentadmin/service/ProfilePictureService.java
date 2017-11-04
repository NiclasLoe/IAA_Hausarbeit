package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.ProfilePicture;

import java.io.FileInputStream;

public interface ProfilePictureService {

    Long saveImage(ProfilePicture profilePicture);

    ProfilePicture loadImage(Long photoId);
}
