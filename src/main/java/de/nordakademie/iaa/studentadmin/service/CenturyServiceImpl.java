package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.CenturyDAO;
import de.nordakademie.iaa.studentadmin.model.Century;
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
}
