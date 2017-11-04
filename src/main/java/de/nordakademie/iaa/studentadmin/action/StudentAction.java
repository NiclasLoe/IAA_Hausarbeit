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
import sun.misc.BASE64Encoder;

import java.util.List;

/**
 * Class that contain all action methods for students.
 *
 * @author Niclas Loeding
 */
public class StudentAction extends ActionSupport implements Preparable {

    /**
     * The student service.
     */
    private StudentService studentService;
    /**
     * The century service.
     */
    private CenturyService centuryService;
    /**
     * The currently edited student.
     */
    private Student student;
    /**
     * The student's identifier.
     */
    private Long studentId;
    /**
     * The company service.
     */
    private CompanyService companyService;
    /**
     * The list of available companies.
     */
    private List<Company> companyList;
    /**
     * The list of available centuries.
     */
    private List<Century> centuryList;
    /**
     * The company's identifier.
     */
    private Long companyId;
    /**
     * The century's identifier formatted as a string.
     */
    private String centuryString;

    /**
     * Validates whether a student is selected.
     */
    public void validateLoadStudent() {
        if ((studentId == null) && (student == null)) {
            addActionError(getText("error.selectStudent"));
        }
    }

    /**
     * Load student for upload preparation.
     *
     * @return Struts outcome.
     */
    public String loadStudentForUpload() {
        student = studentService.loadStudent(student.getId());
        return SUCCESS;
    }

    /**
     * Validates whether a student is selected.
     */
    public void validateExmatriculateStudent() {
        if ((studentId == null) && (student == null)) {
            addActionError(getText("error.selectStudent"));
        }
    }

    /**
     * Validates whether a student is selected.
     */
    public void validateEndActiveStudies() {
        if ((studentId == null) && (student == null)) {
            addActionError(getText("error.selectStudent"));
        }
    }

    /**
     * Validates the input before saving a student.
     */
    public void validateSaveStudent() {
        ActionSupportValidator validator = new ActionSupportValidator(this);
        validator.fieldValidated(Validator.isNull(student.getTitle()),
                "student.title", getText("error.title"));
        validator.fieldValidated(Validator.isStringEmpty(student.getFirstName()),
                "student.firstName", getText("error.firstName"));
        validator.fieldValidated(Validator.isStringEmpty(student.getLastName()),
                "student.lastName", getText("error.lastName"));
        validator.fieldValidated(Validator.isNull(student.getGender()),
                "student.gender", getText("error.gender"));
        validator.fieldValidated(Validator.isValidDate(student.getDateOfBirth()),
                "student.dateOfBirth", getText("error.date"));
        validator.fieldValidated(Validator.isStringEmpty(student.getBirthplace()),
                "student.birthplace", getText("error.birthplace"));
        validator.fieldValidated(!Validator.isValidPhoneNumber(student.getPhoneNumber()),
                "student.phoneNumber", getText("error.phoneNumber"));
        validator.fieldValidated(!Validator.isValidEmail(student.getEmailAddress()),
                "student.emailAddress", getText("error.mail"));
        validator.fieldValidated(!Validator.isValidNumber(student.getPostalCode()),
                "student.postalCode", getText("error.postalCode"));
        validator.fieldValidated(Validator.isStringEmpty(student.getStreetName()),
                "student.streetName", getText("error.streetName"));
        validator.fieldValidated(Validator.isStringEmpty(student.getHouseNumber()),
                "student.houseNumber", getText("error.houseNumber"));
        validator.fieldValidated(Validator.isStringEmpty(student.getCity()),
                "student.city", getText("error.city"));
        validator.fieldValidated(Validator.isStringEmpty(centuryString),
                "centuryString", getText("error.centuryString"));

        Student tempStudent = studentService.loadStudent(student.getId());
        student.setProfilePicture(tempStudent.getProfilePicture());
    }

    /**
     * Validates input before saving a new student.
     */
    public void validateSaveNewStudent() {
        validateSaveStudent();
    }

    /**
     * Method to save currently edited student.
     *
     * @return Struts outcome.
     */
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

    /**
     * Load student with selected identifier.
     *
     * @return Struts outcome.
     */
    public String loadStudent() {
        this.prepareEmptyForm();
        student = studentService.loadStudent(studentId);
        return SUCCESS;
    }

    public String deleteProfilePicture() {
        Student studentTemp = studentService.loadStudent(student.getId());
        studentTemp.setProfilePicture(null);
        studentService.saveStudent(studentTemp, studentTemp.getCompany(), studentTemp.getCentury());
        return SUCCESS;
    }


    /**
     * Save new student.
     *
     * @return Struts outcome.
     */
    public String saveNewStudent() throws Exception {
        CenturyId centuryId = centuryService.returnId(centuryString);
        Century century = centuryService.loadCentury(centuryId);
        Company company = companyService.loadCompany(companyId);
        studentService.saveNewStudent(student, company, century);
        return SUCCESS;
    }

    /**
     * Prepare page.
     */
    @Override
    public void prepare() {
        prepareEmptyForm();
    }

    /**
     * Load centuries and companies.
     *
     * @return Struts outcome.
     */
    public String prepareEmptyForm() {
        companyList = companyService.listCompanies();
        centuryList = centuryService.listCenturies();
        return SUCCESS;
    }

    /**
     * Change student's status to "ALUMNI".
     *
     * @return Struts outcome.
     */
    public String endActiveStudies() throws Exception {
        studentService.endActiveStudies(studentId);
        return SUCCESS;
    }

    /**
     * Change student's status to "DROPPED_OUT".
     *
     * @return Struts outcome.
     */
    public String exmatriculateStudent() throws Exception {
        studentService.exmatriculateStudent(studentId);
        return "success";
    }

    /**
     * Method to prepare filter form.
     *
     * @return Struts outcome.
     */
    public String filterList() throws Exception {
        prepareEmptyForm();
        return SUCCESS;
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
