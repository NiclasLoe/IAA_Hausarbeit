package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.utilities.EntityAlreadyPresentException;

import java.util.List;

public interface CenturyService {

    List<Century> listCenturies();

    CenturyId returnId(String centuryString);

    Century loadCentury(CenturyId centuryId);

    void saveCentury(Century century);
}
