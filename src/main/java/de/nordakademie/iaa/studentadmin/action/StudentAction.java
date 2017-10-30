package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.ActionSupportValidator;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.CenturyService;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import de.nordakademie.iaa.studentadmin.utilities.Validator;

import java.util.List;

public class StudentAction extends ActionSupport implements Preparable {

    private StudentService studentService;
    private CenturyService centuryService;
    private Student student;
    private Long studentId;
    private CompanyService companyService;
    private List<Company> companyList;
    private List<Century> centuryList;
    private Long companyId;
    private String centuryString;

    public void validateLoadStudent() {
        if ((studentId == null) && (student == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    public void validateExmatriculateStudent() {
        if ((studentId == null) && (student == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    public void validateEndActiveStudies() {
        if ((studentId == null) && (student == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    public void validateSaveStudent() {
        ActionSupportValidator validator = new ActionSupportValidator(this);
        validator.fieldValidated(Validator.isNull(student.getTitle()), "student.title", "Title is required.");
        validator.fieldValidated(Validator.isStringEmpty(student.getFirstName()), "student.firstName", "First name is required.");
        validator.fieldValidated(Validator.isStringEmpty(student.getLastName()), "student.lastName", "Last name is required.");
        validator.fieldValidated(Validator.isNull(student.getGender()), "student.gender", "Gender is required.");
        validator.fieldValidated(Validator.isValidDate(student.getDateOfBirth()), "student.dateOfBirth", "Date of birth is required and must not be in the future.");
        validator.fieldValidated(Validator.isStringEmpty(student.getBirthplace()), "student.birthplace", "Birthplace is required.");
        validator.fieldValidated(!Validator.isValidPhoneNumber(student.getPhoneNumber()), "student.phoneNumber",
                "Phone number must be nonempty and only contain numbers. Leading plus (+) is allowed." );
        validator.fieldValidated(!Validator.isValidEmail(student.getEmailAddress()), "student.emailAddress",
                "Email address must be nonempty and contain at least one @ character." );
        validator.fieldValidated(!Validator.isValidNumber(student.getPostalCode()), "student.postalCode",
                "Postal code must be nonempty and only contain numbers." );
        validator.fieldValidated(Validator.isStringEmpty(student.getStreetName()), "student.streetName", "Street name is required.");
        validator.fieldValidated(Validator.isStringEmpty(student.getHouseNumber()), "student.houseNumber", "House number is required.");
        validator.fieldValidated(Validator.isStringEmpty(student.getCity()), "student.city", "City is required.");
        validator.fieldValidated(Validator.isStringEmpty(centuryString), "centuryString", "Century is required.");
    }

    public void validateSaveNewStudent() {
        validateSaveStudent();
    }

    public String saveStudent() throws Exception {
        CenturyId centuryId = centuryService.returnId(centuryString);
        Century century = centuryService.loadCentury(centuryId);
        Company company = null;
        // TODO: If company null, create new one.
        if (companyId != null) {
            company = companyService.loadCompany(companyId);
        }

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

    @Override
    public void prepare() {
        prepareEmptyForm();
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
