package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;
import de.nordakademie.iaa.studentadmin.utilities.ActionSupportValidator;
import de.nordakademie.iaa.studentadmin.utilities.Validator;

import java.util.Date;

public class ApplicantAction extends ActionSupport {

    private ApplicantService applicantService;
    private Applicant applicant;
    private Long applicantId;

    @Override
    public void validate() {
        if ((applicantId == null) && (applicant == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    public void validateSaveApplicant() {
        ActionSupportValidator validator = new ActionSupportValidator(this);
        validator.fieldValidated(Validator.isNull(applicant.getTitle()), "applicant.title", "Title is required.");
        validator.fieldValidated(Validator.isStringEmpty(applicant.getFirstName()), "applicant.firstName", "First name is required.");
        validator.fieldValidated(Validator.isStringEmpty(applicant.getLastName()), "applicant.lastName", "Last name is required.");
        validator.fieldValidated(Validator.isNull(applicant.getGender()), "applicant.gender", "Gender is required.");
        validator.fieldValidated(Validator.isValidDate(applicant.getDateOfBirth()), "applicant.dateOfBirth", "Date of birth is required and must not be in the future.");
        validator.fieldValidated(Validator.isStringEmpty(applicant.getBirthplace()), "applicant.birthplace", "Birthplace is required.");
        validator.fieldValidated(!Validator.isValidPhoneNumber(applicant.getPhoneNumber()), "applicant.phoneNumber",
                "Phone number must be nonempty and only contain numbers. Leading plus (+) is allowed." );
        validator.fieldValidated(!Validator.isValidEmail(applicant.getEmailAddress()), "applicant.emailAddress",
                "Email address must be nonempty and contain at least one @ character." );
        validator.fieldValidated(!Validator.isValidNumber(applicant.getPostalCode()), "applicant.postalCode",
                "Postal code must be nonempty and only contain numbers." );
        validator.fieldValidated(Validator.isStringEmpty(applicant.getStreetName()), "applicant.streetName", "Street name is required.");
        validator.fieldValidated(Validator.isStringEmpty(applicant.getHouseNumber()), "applicant.houseNumber", "House number is required.");
        validator.fieldValidated(Validator.isStringEmpty(applicant.getCity()), "applicant.city", "City is required.");
    }

    public String loadApplicant() {
        applicant = applicantService.loadApplicant(applicantId);
        return SUCCESS;
    }

    public String saveApplicant() throws Exception {
        applicantService.save(applicant);
        return SUCCESS;
    }

    public String deleteApplicant() throws Exception {
        applicantService.delete(applicantId);
        return SUCCESS;
    }

    public void setApplicantService(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
}
