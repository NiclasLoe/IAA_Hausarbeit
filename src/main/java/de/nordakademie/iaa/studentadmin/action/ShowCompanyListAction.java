package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.service.CompanyService;

import java.util.List;

/**
 * Class that contain methods to make list of companies available.
 *
 * @author Lennart Meincke
 */
public class ShowCompanyListAction implements Action {


    private CompanyService companyService;
    private List<Company> companyList;

    @Override
    public String execute() {
        companyList = companyService.listCompanies();
        return SUCCESS;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}