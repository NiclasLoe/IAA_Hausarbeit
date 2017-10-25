package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.CenturyDAO;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.model.CenturyId;
import de.nordakademie.iaa.studentadmin.model.FieldOfStudy;
import de.nordakademie.iaa.studentadmin.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CenturyServiceImpl implements CenturyService {

    @Autowired
    private CenturyDAO centuryDAO;

    @Override
    public List<Century> listCenturies() {
        return centuryDAO.listAll();
    }

    @Override
    public CenturyId returnId(String centuryString) {
        Integer year = Integer.parseInt(centuryString.substring(0, 4));
        String letterCode = centuryString.substring(4, 5);
        FieldOfStudy fieldOfStudy = FieldOfStudy.valueOf(centuryString.substring(5, centuryString.length()));
        return new CenturyId(year, letterCode, fieldOfStudy);
    }

    @Override
    public Century loadCentury(CenturyId centuryId) {
        return centuryDAO.load(centuryId);
    }

    @Override
    public void addStudent(Century century, Student student) {
        century.getStudentList().add(student);
        centuryDAO.save(century);
    }
}
