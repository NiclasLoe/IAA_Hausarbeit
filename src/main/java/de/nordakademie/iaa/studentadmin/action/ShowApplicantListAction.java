package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;

import java.util.List;

/**
 * Class that contain methods to make list of applicants available.
 *
 * @author Niclas Loeding
 */
public class ShowApplicantListAction implements Action {

    /**
     * The applicant service.
     */
    private ApplicantService applicantService;
    /**
     * The list of applicants.
     */
    private List<Applicant> personList;

    /**
     * Load list of applicants.
     *
     * @return Struts outcome.
     */
    @Override
    public String execute() throws Exception {
        personList = applicantService.listApplicants();
        return SUCCESS;
    }

    // Getter and setter

    public List<Applicant> getPersonList() {
        return personList;
    }

    public void setApplicantService(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
}
