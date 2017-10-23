package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.CenturyService;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.util.List;

public class StudentAction extends ActionSupport {

    private StudentService studentService;
    private Student student;
    private Long personId;
    private CompanyService companyService;
    private CenturyService classService;
    private List<Company> companyList;
    private List<Century> centuryList;

    @Override
    public void validate() {
        if ((personId == null) && (student == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    public String saveStudent() throws Exception {
        studentService.saveStudent(student);
        return SUCCESS;
    }

    public String loadStudent() {
        companyList = companyService.listCompanies();
        centuryList = classService.listCenturies();
        student = studentService.loadStudent(personId);
        return SUCCESS;
    }

    public String saveNewStudent() throws Exception {
        studentService.saveNewStudent(student);
        return SUCCESS;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public void setClassService(CenturyService classService) {
        this.classService = classService;
    }
}
