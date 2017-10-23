package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.service.CompanyService;

import java.util.List;

public class CompanyAction extends ActionSupport {

    private CompanyService companyService;

    private List<Company> companyList;

    public String listAll() throws Exception {
        companyList = companyService.listCompanies();
        return SUCCESS;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }
}
