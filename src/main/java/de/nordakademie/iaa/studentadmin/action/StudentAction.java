package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.CenturyService;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;

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

    public void validateSaveStudent() {
        addErrorIfNull(student.getTitle(), "student.title", "Title is required.");
        addErrorIfStringIsEmpty(student.getFirstName(), "student.firstName", "First name is required.");
        addErrorIfStringIsEmpty(student.getLastName(), "student.lastName", "Last name is required.");
        addErrorIfNull(student.getGender(), "student.gender", "Gender is required.");
        addErrorIfNull(student.getDateOfBirth(), "student.dateOfBirth", "Date of birth is required.");
        addErrorIfStringIsEmpty(student.getBirthplace(), "student.birthplace", "Birthplace is required.");

        // Phone number only needs to be numerical, no constraints for length.
        if (student.getPhoneNumber().length() == 0 || !student.getPhoneNumber().matches("\\+?[0-9]+")) {
            addFieldError( "student.phoneNumber", "Phone number must be nonempty and only contain numbers. Leading plus (+) is allowed." );
        }

        // It's almost impossible to perfectly check for all RFC822 compliant emails, so before we reject a valid email, we just have a very basic check for @.
        if (student.getEmailAddress() == null || !student.getEmailAddress().contains("@")) {
            addFieldError( "student.emailAddress", "Email address must be nonempty and contain at least one @ character." );
        }

        // Postal code only needs to be numerical, no constraints for length (to support different countries).
        if (student.getPostalCode() == null || student.getPostalCode().toString().length() == 0 || !student.getPostalCode().toString().matches("[0-9]+")) {
            addFieldError( "student.postalCode", "Postal code must be nonempty and only contain numbers." );
        }

        addErrorIfStringIsEmpty(student.getStreetName(), "student.streetName", "Street name is required.");
        addErrorIfStringIsEmpty(student.getHouseNumber(), "student.houseNumber", "House number is required.");
        addErrorIfStringIsEmpty(student.getCity(), "student.city", "City is required.");
        addErrorIfStringIsEmpty(centuryString, "centuryString", "Century is required.");
    }

    public void validateSaveNewStudent() {
        validateSaveStudent();
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
