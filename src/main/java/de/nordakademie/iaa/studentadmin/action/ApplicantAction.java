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
