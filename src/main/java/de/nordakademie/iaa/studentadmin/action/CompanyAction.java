package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.service.CompanyService;

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
        addErrorIfStringIsEmpty(company.getCompanyName1(), "company.companyName1", "Company name 1 is required.");
        addErrorIfStringIsEmpty(company.getCompanyName2(), "company.companyName2", "Company name 2 is required.");
        addErrorIfStringIsEmpty(company.getShortName(), "company.shortName", "Company short name is required.");
        addErrorIfStringIsEmpty(company.getContactPerson(), "company.contactPerson", "Company contact person is required.");

        // Phone number only needs to be numerical, no constraints for length.
        if (company.getPhoneNumber() == null || company.getPhoneNumber().toString().length() == 0 || !company.getPhoneNumber().toString().matches("\\+?[0-9]+")) {
            addFieldError( "company.phoneNumber", "Phone number must be nonempty and only contain numbers. Leading plus (+) is allowed." );
        }

        // Phone number only needs to be numerical, no constraints for length.
        if (company.getFaxNumber() == null || company.getFaxNumber().toString().length() == 0 || !company.getFaxNumber().toString().matches("\\+?[0-9]+")) {
            addFieldError( "company.faxNumber", "Fax number must be nonempty and only contain numbers. Leading plus (+) is allowed." );
        }

        // It's almost impossible to perfectly check for all RFC822 compliant emails, so before we reject a valid email, we just have a very basic check for @.
        if (company.getMailAddress() == null || !company.getMailAddress().contains("@")) {
            addFieldError( "company.mailAddress", "Email address must be nonempty and contain at least one @ character." );
        }

        // Postal code only needs to be numerical, no constraints for length (to support different countries).
        if (company.getPostalCode() == null || company.getPostalCode().toString().length() == 0 || !company.getPostalCode().toString().matches("[0-9]+")) {
            addFieldError( "company.postalCode", "Postal code must be nonempty and only contain numbers." );
        }

        addErrorIfStringIsEmpty(company.getStreetName(), "company.streetName", "Street name is required.");
        addErrorIfStringIsEmpty(company.getHouseNumber(), "company.houseNumber", "House number is required.");
        addErrorIfStringIsEmpty(company.getCity(), "company.city", "City is required.");
    }

    private void addErrorIfNull(Object object, String fieldName, String errorMessage) {
        if (object == null) {
            addFieldError(fieldName, errorMessage);
        }
    }

    private void addErrorIfStringIsEmpty(String string, String fieldName, String errorMessage) {
        if (string == null || string.length() == 0) {
            addFieldError(fieldName, errorMessage);
        }
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
