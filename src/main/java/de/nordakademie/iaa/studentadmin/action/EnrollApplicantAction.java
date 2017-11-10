package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.*;
import de.nordakademie.iaa.studentadmin.service.*;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;
import de.nordakademie.iaa.studentadmin.utilities.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that contains required methods to enroll an applicant as a student.
 *
 * @author Niclas Loeding
 */
public class EnrollApplicantAction extends ActionSupport {

    /**
     * The student service.
     */
    private StudentService studentService;
    /**
     * The applicant service.
     */
    private ApplicantService applicantService;
    /**
     * The company Service.
     */
    private CompanyService companyService;
    /**
     * The century service.
     */
    private CenturyService centuryService;
    /**
     * The student to be enrolled.
     */
    private Student student;
    /**
     * The applicant to be transformed to be a student.
     */
    private Applicant applicant;
    /**
     * The company's identifier.
     */
    private Long companyId;
    /**
     * The list of all available companies.
     */
    private List<Company> companyList;
    /**
     * The list of all available centuries.
     */
    private ArrayList<Century> centuryList;
    /**
     * The applicant's identifier.
     */
    private Long applicantId;
    /**
     * The century's identifier as a String.
     */
    private String centuryString;

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
     * Method to enroll applicant and delete it afterwards.
     *
     * @return Struts outcome.
     */
    public String enrollApplicant() {
        try {
            // Load century and company
            Century century = null;
            Company company = (!Validator.isStringEmpty(centuryString))
                    ? companyService.loadCompany(companyId) : null;

            if (!Validator.isStringEmpty(centuryString)) {
                CenturyId centuryId = centuryService.returnId(centuryString);
                century = centuryService.loadCentury(centuryId);
            }

            // Save new student and delete applicant entry
            applicant = applicantService.loadApplicant(applicant.getId());
            studentService.saveNewStudent(student, company, century, applicant.getDocument());
            Long applicantToDeleteId = applicant.getId();
            applicantService.delete(applicantToDeleteId);
        } catch (EntityNotFoundException e) {
            addActionError(getText("error.ApplicantNotFound"));
        }
        return SUCCESS;

    }

    /**
     * Load selected applicant.
     *
     * @return Struts outcome.
     */
    public String loadApplicant() {
        applicant = applicantService.loadApplicant(applicantId);
        companyList = companyService.listCompanies();
        centuryList = new ArrayList<>();
        centuryList.addAll(centuryService.listCenturies());

        return SUCCESS;
    }

    // Getter and setter

    public void setCenturyService(CenturyService centuryService) {
        this.centuryService = centuryService;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setApplicantService(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
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

    public ArrayList<Century> getCenturyList() {
        return centuryList;
    }

    public void setCenturyList(ArrayList<Century> centuryList) {
        this.centuryList = centuryList;
    }

    public String getCenturyString() {
        return centuryString;
    }

    public void setCenturyString(String centuryString) {
        this.centuryString = centuryString;
    }
}
