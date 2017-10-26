package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.CenturyService;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.util.List;

public class StudentAction extends ActionSupport {

    private StudentService studentService;
    private CenturyService centuryService;
    private Student student;
    private Long studentId;
    private CompanyService companyService;
    private List<Company> companyList;
    private List<Century> centuryList;
    private Long companyId;
    private String centuryString;

    @Override
    public void validate() {
        if ((studentId == null) && (student == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    public String saveStudent() throws Exception {
        CenturyId centuryId = centuryService.returnId(centuryString);
        Century century = centuryService.loadCentury(centuryId);
        Company company = companyService.loadCompany(companyId);
        studentService.saveStudent(student, company, century);
        return SUCCESS;
    }

    public String loadStudent() {
        this.prepareEmptyForm();
        student = studentService.loadStudent(studentId);
        return SUCCESS;
    }

    public String saveNewStudent() throws Exception {
        CenturyId centuryId = centuryService.returnId(centuryString);
        Century century = centuryService.loadCentury(centuryId);
        Company company = companyService.loadCompany(companyId);
        studentService.saveNewStudent(student, company, century);
        return SUCCESS;
    }

    public String prepareEmptyForm() {
        companyList = companyService.listCompanies();
        centuryList = centuryService.listCenturies();
        return SUCCESS;
    }

    public String endActiveStudies() throws Exception {
        studentService.endActiveStudies(studentId);
        return SUCCESS;
    }

    public String exmatriculateStudent() throws Exception {
        studentService.exmatriculateStudent(studentId);
        return "success";
    }

    // Getter and Setter

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setCenturyService(CenturyService centuryService) {
        this.centuryService = centuryService;
    }

    public String getCenturyString() {
        return centuryString;
    }

    public void setCenturyString(String centuryString) {
        this.centuryString = centuryString;
    }
}
