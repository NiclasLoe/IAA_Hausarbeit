package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.CenturyDAO;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Maniple service implementation.
 *
 * @author Lennart Meincke
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Component
public class ManipleServiceImpl implements ManipleService {

    /**
     * The century DAO.
     */
    @Autowired
    private CenturyDAO centuryDAO;

    @Override
    public List<String> getAvailableManiple() {
        List<Century> centuryList = centuryDAO.listAll();
        Set<String> manipleSet = new HashSet<>();
        String availableManiple;
        for (Century century: centuryList) {
            availableManiple = century.getFieldOfStudy().toString() + '-' + century.getYear();
            manipleSet.add(availableManiple);
        }
        List<String> manipleList = new ArrayList<>();
        manipleList.addAll(manipleSet);
        return manipleList;
    }

    @Override
    public FieldOfStudy returnFieldOfStudy(String maniple) {
        return FieldOfStudy.valueOf(maniple.substring(0, maniple.length()-5));
    }

    @Override
    public String returnYear(String maniple) {
        return maniple.substring((maniple.length() - 4));
    }

    public void setCenturyDAO(CenturyDAO centuryDAO) {
        this.centuryDAO = centuryDAO;
    }
}
