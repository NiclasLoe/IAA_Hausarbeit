package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;

import java.util.List;

public interface CenturyService {

    List<Century> listCenturies();

    CenturyId returnId(String centuryString);

    Century loadCentury(CenturyId centuryId);

    List<Century> listAll();

    void saveCentury(Century century);
}
