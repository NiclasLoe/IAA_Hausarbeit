package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.utilities.ActionSupportValidator;
import de.nordakademie.iaa.studentadmin.utilities.Validator;

/**
 * Class that contains all action methods for companies.
 *
 * @author Niclas Loeding
 */
public class CompanyAction extends ActionSupport {

    /**
     * The company service.
     */
    private CompanyService companyService;
    /**
     * The company's identifier.
     */
    private Long companyId;
    /**
     * The currently edited company.
     */
    private Company company;

    /**
     * Validates whether a company is selected.
     */
    public void validateLoadCompany() {
        if ((company == null) && (companyId == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    /**
     * Validates input before saving the currently edited company.
     */
    public void validateSaveCompany() {
        ActionSupportValidator validator = new ActionSupportValidator(this);
        validator.fieldValidated(Validator.isStringEmpty(company.getCompanyName1()),
                "company.companyName1", "error.companyName");
        /* validator.fieldValidated(Validator.isStringEmpty(company.getCompanyName2()),
                "company.companyName2", "Company name 2 is required.");*/
        validator.fieldValidated(Validator.isStringEmpty(company.getShortName()),
                "company.shortName", "error.shortName");
        validator.fieldValidated(Validator.isStringEmpty(company.getContactPerson()),
                "company.contactPerson", "error.contactPerson");
        validator.fieldValidated(!Validator.isValidPhoneNumber(company.getPhoneNumber()),
                "company.phoneNumber", "error.phoneNumber");
        validator.fieldValidated(!Validator.isValidPhoneNumber(company.getFaxNumber()),
                "company.faxNumber", "error.faxNumber");
        validator.fieldValidated(!Validator.isValidEmail(company.getMailAddress()),
                "company.mailAddress", "error.mail");
        validator.fieldValidated(!Validator.isValidNumber(company.getPostalCode()),
                "company.postalCode", "error.postalCode");
        validator.fieldValidated(Validator.isStringEmpty(company.getStreetName()),
                "company.streetName", "error.street");
        validator.fieldValidated(Validator.isStringEmpty(company.getHouseNumber()),
                "company.houseNumber", "error.houseNumber");
        validator.fieldValidated(Validator.isStringEmpty(company.getCity()),
                "company.city", "error.city");
    }

    /**
     * Loads the selected company.
     *
     * @return Struts outcome
     */
    public String loadCompany() throws Exception {
        company = companyService.loadCompany(companyId);
        return SUCCESS;
    }

    /**
     * Saves the currently created company.
     *
     * @return Struts outcome
     */
    public String saveCompany() throws Exception {
        companyService.save(company);
        return SUCCESS;
    }

    // Getter and setter

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
