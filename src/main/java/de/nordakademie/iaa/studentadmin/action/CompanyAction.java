package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.service.CompanyService;

import java.util.List;

public class CompanyAction extends ActionSupport {

    private CompanyService companyService;
    private List<Company> companyList;
    private Long companyId;
    private Company company;

    public void validateLoadCompany() {
        if ((company == null) && (companyId == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String loadCompany() throws Exception {
        company = companyService.loadCompany(companyId);
        return SUCCESS;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String saveCompany() throws Exception {
        companyService.save(company);
        return SUCCESS;
    }
}
