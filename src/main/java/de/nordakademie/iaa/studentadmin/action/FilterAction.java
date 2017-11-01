package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;
import de.nordakademie.iaa.studentadmin.service.CenturyService;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

import java.util.List;

/**
 * Class that contains all filter methods.
 *
 * @author Niclas Loeding
 */
public class FilterAction extends ActionSupport implements Preparable {

    /**
     * The student service.
     */
    private StudentService studentService;
    /**
     * The century service.
     */
    private CenturyService centuryService;
    /**
     * The company service.
     */
    private CompanyService companyService;
    /**
     * The applicant service.
     */
    private ApplicantService applicantService;
    /**
     * First name input.
     */
    private String selectedFirstName;
    /**
     * Last name input.
     */
    private String selectedLastName;
    /**
     * Student id input.
     */
    private String selectedStudentId;
    /**
     * Year input.
     */
    private String selectedYear;
    /**
     * Field of study input.
     */
    private FieldOfStudy selectedFieldOfStudy;
    /**
     * Company Id input.
     */
    private Long selectedCompanyId;
    /**
     * Century id as string input.
     */
    private String selectedCenturyString;
    /**
     * The list of students.
     */
    private List<Student> studentList;
    /**
     * The list of applicants.
     */
    private List<Applicant> personList;

    @Override
    public void prepare() throws Exception {
    }

    /**
     * Method to apply filters on student list.
     *
     * @return Struts outcome.
     */
    public String filterStudentList() {
        Century century = null;
        FieldOfStudy fieldOfStudy = null;
        Company company = null;

        if (selectedCenturyString != "") {
            CenturyId centuryId = centuryService.returnId(selectedCenturyString);
            century = centuryService.loadCentury(centuryId);
        }

        if (selectedCompanyId != null) {
            company = companyService.loadCompany(selectedCompanyId);
        }

        if (selectedFieldOfStudy != null) {
            fieldOfStudy = selectedFieldOfStudy;
        }

        studentList = studentService.
                filterActiveStudentList(selectedFirstName, selectedLastName, selectedStudentId,
                        company, century, fieldOfStudy, selectedYear);

        return SUCCESS;
    }

    /**
     * Method to apply filters on alumni list.
     *
     * @return Struts outcome.
     */
    public String filterAlumniList() {
        Century century = null;
        Company company = null;
        FieldOfStudy fieldOfStudy = null;

        if (selectedCenturyString != "") {
            CenturyId centuryId = centuryService.returnId(selectedCenturyString);
            century = centuryService.loadCentury(centuryId);
        }

        if (selectedCompanyId != null) {
            company = companyService.loadCompany(selectedCompanyId);
        }

        if (selectedFieldOfStudy != null) {
            fieldOfStudy = selectedFieldOfStudy;
        }

        studentList = studentService.
                filterAlumniList(selectedFirstName, selectedLastName, selectedStudentId,
                        company, century, fieldOfStudy, selectedYear);

        return SUCCESS;
    }

    /**
     * Method to apply filters on applicant list.
     *
     * @return Struts outcome.
     */
    public String filterApplicantList() {

        FieldOfStudy fieldOfStudy = null;
        if (selectedFieldOfStudy != null) {
            fieldOfStudy = selectedFieldOfStudy;
        }
        personList = applicantService.
                filterApplicantList(selectedFirstName, selectedLastName,
                        fieldOfStudy);
        return SUCCESS;
    }

    // Getter and setter

    public void setApplicantService(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public String getSelectedFirstName() {
        return selectedFirstName;
    }

    public void setSelectedFirstName(String selectedFirstName) {
        this.selectedFirstName = selectedFirstName;
    }

    public String getSelectedLastName() {
        return selectedLastName;
    }

    public void setSelectedLastName(String selectedLastName) {
        this.selectedLastName = selectedLastName;
    }

    public String getSelectedStudentId() {
        return selectedStudentId;
    }

    public void setSelectedStudentId(String selectedStudentId) {
        this.selectedStudentId = selectedStudentId;
    }

    public Long getSelectedCompanyId() {
        return selectedCompanyId;
    }

    public void setSelectedCompanyId(Long selectedCompanyId) {
        this.selectedCompanyId = selectedCompanyId;
    }

    public String getSelectedCenturyString() {
        return selectedCenturyString;
    }

    public void setSelectedCenturyString(String selectedCenturyString) {
        this.selectedCenturyString = selectedCenturyString;
    }

    public void setCenturyService(CenturyService centuryService) {
        this.centuryService = centuryService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(String selectedYear) {
        this.selectedYear = selectedYear;
    }

    public FieldOfStudy getSelectedFieldOfStudy() {
        return selectedFieldOfStudy;
    }

    public void setSelectedFieldOfStudy(FieldOfStudy selectedFieldOfStudy) {
        this.selectedFieldOfStudy = selectedFieldOfStudy;
    }

    public List<Applicant> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Applicant> applicantList) {
        this.personList = personList;
    }
}
