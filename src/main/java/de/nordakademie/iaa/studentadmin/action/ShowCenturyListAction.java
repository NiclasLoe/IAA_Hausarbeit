package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.service.CenturyService;

import java.util.List;

/**
 * Class that contain methods to make list of centuries available.
 *
 * @author Lennart Meincke
 */
public class ShowCenturyListAction implements Action {

    /**
     * The list of available centuries.
     */
    private List<Century> centuryList;
    /**
     * The century service.
     */
    private CenturyService centuryService;

    /**
     * Method to load list of centuries.
     *
     * @return Struts outcome.
     */
    @Override
    public String execute() {
        centuryList = centuryService.listCenturies();
        return SUCCESS;
    }

    // Getter and setter

    public List<Century> getCenturyList() {
        return centuryList;
    }

    public void setCenturyService(CenturyService centuryService) {
        this.centuryService = centuryService;
    }
}