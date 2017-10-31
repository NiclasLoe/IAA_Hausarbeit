package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Person;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;

import java.util.List;

public class ShowApplicantListAction implements Action {

    private ApplicantService applicantService;

    private List<Applicant> personList;

    @Override
    public String execute() throws Exception {
        personList = applicantService.listApplicants();
        return SUCCESS;
    }

    public List<Applicant> getPersonList() {
        return personList;
    }

    public void setApplicantService(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
}
