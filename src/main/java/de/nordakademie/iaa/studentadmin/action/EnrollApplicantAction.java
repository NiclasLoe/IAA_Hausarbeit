package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.*;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;
import de.nordakademie.iaa.studentadmin.service.CenturyService;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;

import java.util.ArrayList;
import java.util.List;

public class EnrollApplicantAction extends ActionSupport {

    private StudentService studentService;
    private ApplicantService applicantService;
    private CompanyService companyService;
    private CenturyService centuryService;
    private Student student;
    private Applicant applicant;
    private Long companyId;
    private List<Company> companyList;
    private ArrayList<Century> centuryList;
    private Long applicantId;
    private String centuryString;

    @Override
    public void validate() {
        if ((applicantId == null) && (applicant == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    public String enrollApplicant() throws Exception {
        CenturyId centuryId = centuryService.returnId(centuryString);
        Century century = centuryService.loadCentury(centuryId);
        Company company = companyService.loadCompany(companyId);
        studentService.saveNewStudent(student, company, century);
        Long applicantToDeleteId = applicant.getId();
        applicantService.delete(applicantToDeleteId);
        return SUCCESS;
    }

    public String loadApplicant() {
        applicant = applicantService.loadApplicant(applicantId);
        companyList = companyService.listCompanies();
        centuryList = new ArrayList<>();
        centuryList.addAll(centuryService.listCenturies());

        return SUCCESS;
    }

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
