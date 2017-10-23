package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.dao.CenturyDAO;
import de.nordakademie.iaa.studentadmin.model.Century;

import java.util.List;

public class CenturyAction extends ActionSupport {

    private List<Century> centuryList;
    private CenturyDAO centuryDAO;

    public String listAll() throws Exception {
        centuryList = centuryDAO.listAll();
        return SUCCESS;
    }

    public List<Century> getCenturyList() {
        return centuryList;
    }

    public void setGroupDAO(CenturyDAO centuryDAO) {
        this.centuryDAO = centuryDAO;
    }
}
