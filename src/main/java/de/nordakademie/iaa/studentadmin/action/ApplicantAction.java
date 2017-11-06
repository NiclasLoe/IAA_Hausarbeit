package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;
import de.nordakademie.iaa.studentadmin.utilities.ActionSupportValidator;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;
import de.nordakademie.iaa.studentadmin.utilities.Validator;

/**
 * Class that contains all action methods for applicants.
 *
 * @author Niclas Loeding
 */

public class ApplicantAction extends ActionSupport {

    /**
     * The applicant service.
     */
    private ApplicantService applicantService;
    /**
     * The applicant currently edited.
     */
    private Applicant applicant;
    /**
     * The applicant's identifier.
     */
    private Long applicantId;

    /**
     * Validates whether an applicant is selected.
     */
    @Override
    public void validate() {
        if ((applicantId == null) && (applicant == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    /**
     * Validates input before saving the currently edited applicant.
     */
    public void validateSaveApplicant() {
        ActionSupportValidator validator = new ActionSupportValidator(this);
        validator.fieldValidated(Validator.isNull(applicant.getTitle()),
                "applicant.title", getText("error.title"));
        validator.fieldValidated(Validator.isStringEmpty(applicant.getFirstName()),
                "applicant.firstName", getText("error.firstName"));
        validator.fieldValidated(Validator.isStringEmpty(applicant.getLastName()),
                "applicant.lastName", getText("error.lastName"));
        validator.fieldValidated(Validator.isNull(applicant.getGender()),
                "applicant.gender", getText("error.gender"));
        validator.fieldValidated(Validator.isValidDate(applicant.getDateOfBirth()),
                "applicant.dateOfBirth", getText("error.dateOfBirth"));
        validator.fieldValidated(Validator.isStringEmpty(applicant.getBirthplace()),
                "applicant.birthplace", getText("error.birthplace"));
        validator.fieldValidated(!Validator.isValidPhoneNumber(applicant.getPhoneNumber()),
                "applicant.phoneNumber", getText("error.phoneNumber"));
        validator.fieldValidated(!Validator.isValidEmail(applicant.getEmailAddress()),
                "applicant.emailAddress", getText("error.email"));
        validator.fieldValidated(!Validator.isValidNumber(applicant.getPostalCode()),
                "applicant.postalCode", getText("error.postalCode"));
        validator.fieldValidated(Validator.isStringEmpty(applicant.getStreetName()),
                "applicant.streetName", getText("error.street"));
        validator.fieldValidated(Validator.isStringEmpty(applicant.getHouseNumber()),
                "applicant.houseNumber", getText("error.houseNumber"));
        validator.fieldValidated(Validator.isStringEmpty(applicant.getCity()),
                "applicant.city", getText("error.city"));
    }

    /**
     * Loads the selected applicant.
     *
     * @return Struts outcome
     */
    public String loadApplicant() {
        applicant = applicantService.loadApplicant(applicantId);
        return SUCCESS;
    }

    /**
     * Save the currently edited applicant.
     *
     * @return Struts outcome.
     */
    public String saveApplicant() {
        applicantService.save(applicant);
        return SUCCESS;
    }

    /**
     * Deletes the applicant with the current identifier.
     *
     * @return Struts outcome
     */
    public String deleteApplicant() {
        try {
            applicantService.delete(applicantId);
        } catch (EntityNotFoundException e) {
            addActionError(getText("error.ApplicantNotFound"));
        }
        return SUCCESS;
    }

    /**
     * Method to delete document stored in applicant.
     *
     * @return Struts outcome.
     */
    public String deleteDocument() {
        Applicant applicantTemp = applicantService.loadApplicant(applicant.getId());
        applicantTemp.setDocument(null);
        applicantService.save(applicantTemp);
        return SUCCESS;
    }

    // Getter and setter
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
