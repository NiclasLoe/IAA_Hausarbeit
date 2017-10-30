package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.service.CenturyService;

import java.util.List;

public class ShowCenturyListAction implements Action {

    private List<Century> centuryList;
    private CenturyService centuryService;

    @Override
    public String execute() throws Exception {
        centuryList = centuryService.listCenturies();
        return SUCCESS;
    }

    public List<Century> getCenturyList() {
        return centuryList;
    }

    public void setCenturyService(CenturyService centuryService) {
        this.centuryService = centuryService;
    }
}