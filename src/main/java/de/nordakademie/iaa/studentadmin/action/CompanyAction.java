package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.utilities.ActionSupportValidator;
import de.nordakademie.iaa.studentadmin.utilities.Validator;

import java.util.List;

public class CompanyAction extends ActionSupport {

    private CompanyService companyService;
    private Long companyId;
    private Company company;

    public void validateLoadCompany() {
        if ((company == null) && (companyId == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    public void validateSaveCompany() {
        ActionSupportValidator validator = new ActionSupportValidator(this);
        validator.fieldValidated(Validator.isStringEmpty(company.getCompanyName1()), "company.companyName1", "Company name 1 is required.");
        validator.fieldValidated(Validator.isStringEmpty(company.getCompanyName2()), "company.companyName2", "Company name 2 is required.");
        validator.fieldValidated(Validator.isStringEmpty(company.getShortName()), "company.shortName", "Company short name is required.");
        validator.fieldValidated(Validator.isStringEmpty(company.getContactPerson()), "company.contactPerson", "Company contact person is required.");
        validator.fieldValidated(!Validator.isValidPhoneNumber(company.getPhoneNumber()), "company.phoneNumber",
                "Phone number must be nonempty and only contain numbers. Leading plus (+) is allowed." );
        validator.fieldValidated(!Validator.isValidPhoneNumber(company.getFaxNumber()), "company.faxNumber",
                "Fax number must be nonempty and only contain numbers. Leading plus (+) is allowed." );
        validator.fieldValidated(!Validator.isValidEmail(company.getMailAddress()), "company.mailAddress",
                "Email address must be nonempty and contain at least one @ character." );
        validator.fieldValidated(!Validator.isValidNumber(company.getPostalCode()), "company.postalCode",
                "Postal code must be nonempty and only contain numbers." );
        validator.fieldValidated(Validator.isStringEmpty(company.getStreetName()), "company.streetName", "Street name is required.");
        validator.fieldValidated(Validator.isStringEmpty(company.getHouseNumber()), "company.houseNumber", "House number is required.");
        validator.fieldValidated(Validator.isStringEmpty(company.getCity()), "company.city", "City is required.");
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
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
