package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;
import de.nordakademie.iaa.studentadmin.service.CenturyService;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.util.List;

public class EnrollApplicantAction extends ActionSupport {

    private StudentService studentService;
    private ApplicantService applicantService;
    private CompanyService companyService;
    private CenturyService classService;
    private Student student;
    private Applicant applicant;

    private List<Company> companyList;
    private List<Century> centuryList;
    private Long applicantId;


    public String enrollApplicant() throws Exception {
        studentService.saveNewStudent(student);
        Long applicantToDeleteId = applicant.getId();
        applicantService.delete(applicantToDeleteId);
        return SUCCESS;
    }

    public String loadApplicant() {
        applicant = applicantService.loadApplicant(applicantId);
        companyList = companyService.listCompanies();
        centuryList = classService.listCenturies();
        return SUCCESS;
    }

    public void setClassService(CenturyService classService) {
        this.classService = classService;
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

    public List<Century> getCenturyList() {
        return centuryList;
    }

    public void setCenturyList(List<Century> centuryList) {
        this.centuryList = centuryList;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}
