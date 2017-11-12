package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.CenturyDAO;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.utilities.EntityAlreadyPresentException;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Century service implementation.
 *
 * @author Lennart Meincke
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Component
public class CenturyServiceImpl implements CenturyService {

    /**
     * The century DAO.
     */
    @Autowired
    private CenturyDAO centuryDAO;

    @Override
    public List<Century> listCenturies() {
        return centuryDAO.listAll();
    }

    @Override
    public CenturyId returnId(String centuryString) {
        String year = centuryString.substring(0, 4);
        String letterCode = centuryString.substring(4, 5);
        FieldOfStudy fieldOfStudy = FieldOfStudy.valueOf(centuryString.substring(5, centuryString.length()));
        return new CenturyId(year, letterCode, fieldOfStudy);
    }

    @Override
    public Century loadCentury(CenturyId centuryId) {
        return centuryDAO.load(centuryId);
    }

    @Override
    public void saveCentury(Century century) throws EntityAlreadyPresentException {
        CenturyId centuryId = new CenturyId(century.getYear(), century.getLetterCode(), century.getFieldOfStudy());
        Century centuryTemp = loadCentury(centuryId);
        if (centuryTemp != null) {
            throw new EntityAlreadyPresentException();
        } else {
            centuryDAO.save(century);
        }
    }

    // Getter and setter

    public void setCenturyDAO(CenturyDAO centuryDAO) {
        this.centuryDAO = centuryDAO;
    }
}
