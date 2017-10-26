package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.CenturyDAO;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.model.FieldOfStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ManipleServiceImpl implements ManipleService {

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
        return FieldOfStudy.valueOf(maniple.substring(0, 4));
    }

    @Override
    public Integer returnYear(String maniple) {
        Integer year = Integer.parseInt(maniple.substring((maniple.length() - 4)));
        return year;
    }

    public void setCenturyDAO(CenturyDAO centuryDAO) {
        this.centuryDAO = centuryDAO;
    }
}
