package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;

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
        addErrorIfNull(applicant.getTitle(), "applicant.title", "Title is required.");
        addErrorIfStringIsEmpty(applicant.getFirstName(), "applicant.firstName", "First name is required.");
        addErrorIfStringIsEmpty(applicant.getLastName(), "applicant.lastName", "Last name is required.");
        addErrorIfNull(applicant.getGender(), "applicant.gender", "Gender is required.");
        addErrorIfNull(applicant.getDateOfBirth(), "applicant.dateOfBirth", "Date of birth is required.");
        addErrorIfStringIsEmpty(applicant.getBirthplace(), "applicant.birthplace", "Birthplace is required.");

        // Phone number only needs to be numerical, no constraints for length.
        if (applicant.getPhoneNumber().length() == 0 || !applicant.getPhoneNumber().matches("\\+?[0-9]+")) {
            addFieldError( "applicant.phoneNumber", "Phone number must be nonempty and only contain numbers. Leading plus (+) is allowed." );
        }

        // It's almost impossible to perfectly check for all RFC822 compliant emails, so before we reject a valid email, we just have a very basic check for @.
        if (applicant.getEmailAddress() == null || !applicant.getEmailAddress().contains("@")) {
            addFieldError( "applicant.emailAddress", "Email address must be nonempty and contain at least one @ character." );
        }

        // Postal code only needs to be numerical, no constraints for length (to support different countries).
        if (applicant.getPostalCode() == null || applicant.getPostalCode().toString().length() == 0 || !applicant.getPostalCode().toString().matches("[0-9]+")) {
            addFieldError( "applicant.postalCode", "Postal code must be nonempty and only contain numbers." );
        }

        addErrorIfStringIsEmpty(applicant.getStreetName(), "applicant.streetName", "Street name is required.");
        addErrorIfStringIsEmpty(applicant.getHouseNumber(), "applicant.houseNumber", "House number is required.");
        addErrorIfStringIsEmpty(applicant.getCity(), "applicant.city", "City is required.");
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
