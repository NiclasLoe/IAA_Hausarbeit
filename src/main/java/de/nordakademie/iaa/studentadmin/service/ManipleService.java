package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

import java.util.List;

public interface ManipleService {


    List<String> getAvailableManiple();

    FieldOfStudy returnFieldOfStudy(String maniple);

    Integer returnYear(String maniple);
}
