package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.CompanyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import de.nordakademie.iaa.studentadmin.utilities.ActionSupportValidator;
import de.nordakademie.iaa.studentadmin.utilities.ExcelCreator;
import de.nordakademie.iaa.studentadmin.utilities.FileInputUtil;
import de.nordakademie.iaa.studentadmin.utilities.Validator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that contains all action methods for companies.
 *
 * @author Niclas Loeding
 */
public class CompanyAction extends ActionSupport {

    /**
     * The company service.
     */
    private CompanyService companyService;
    /**
     * The student service.
     */
    private StudentService studentService;
    /**
     * The company's identifier.
     */
    private Long companyId;
    /**
     * The currently edited company.
     */
    private Company company;
    /**
     * Input stream to export file.
     */
    private InputStream fileInputStream;

    /**
     * Validates whether a company is selected.
     */
    public void validateLoadCompany() {
        if ((company == null) && (companyId == null)) {
            addActionError(getText("error.selectCompany"));
        }
    }

    /**
     * Validates input before saving the currently edited company.
     */
    public void validateSaveCompany() {
        ActionSupportValidator validator = new ActionSupportValidator(this);
        validator.fieldValidated(Validator.isStringEmpty(company.getCompanyName1()),
                "company.companyName1", getText("error.companyName"));
        validator.fieldValidated(Validator.isStringEmpty(company.getShortName()),
                "company.shortName", getText("error.shortName"));
        validator.fieldValidated(Validator.isStringEmpty(company.getContactPerson()),
                "company.contactPerson", getText("error.contactPerson"));
        validator.fieldValidated(!Validator.isValidPhoneNumber(company.getPhoneNumber()),
                "company.phoneNumber", getText("error.phoneNumber"));
        validator.fieldValidated(!Validator.isValidPhoneNumber(company.getFaxNumber()),
                "company.faxNumber", getText("error.faxNumber"));
        validator.fieldValidated(!Validator.isValidEmail(company.getMailAddress()),
                "company.mailAddress", getText("error.mail"));
        validator.fieldValidated(!Validator.isValidNumber(company.getPostalCode()),
                "company.postalCode", getText("error.postalCode"));
        validator.fieldValidated(Validator.isStringEmpty(company.getStreetName()),
                "company.streetName", getText("error.street"));
        validator.fieldValidated(Validator.isStringEmpty(company.getHouseNumber()),
                "company.houseNumber", getText("error.houseNumber"));
        validator.fieldValidated(Validator.isStringEmpty(company.getCity()),
                "company.city", getText("error.city"));
    }

    /**
     * Validates whether a company is selected.
     */
    public void validateDownloadCompanyList() {
        if ((companyId == null) && (company == null)) {
            addActionError(getText("error.selectCompany"));
        }
    }

    /**
     * Loads the selected company.
     *
     * @return Struts outcome
     */
    public String loadCompany() throws Exception {
        company = companyService.loadCompany(companyId);
        return SUCCESS;
    }

    /**
     * Saves the currently created company.
     *
     * @return Struts outcome
     */
    public String saveCompany() {
        companyService.save(company);
        return SUCCESS;
    }

    /**
     * Method to download excel including all active students from that company.
     *
     * @return Struts outcome.
     */
    public String downloadCompanyList() {
        FileInputUtil fileInputUtil = new FileInputUtil();
        // Load Company by identifier
        Company companyTemp = companyService.loadCompany(companyId);

        // Get list of students for the workbook
        List<Student> students = studentService.listStudentsByCompany(companyTemp);
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.addAll(students);

        // Create attendance list
        ExcelCreator excelCreator = new ExcelCreator();
        HSSFWorkbook wb = excelCreator.createCompanyList(studentList, companyTemp.getShortName());

        // try to export the created workbook
        try {
            setFileInputStream(fileInputUtil.createFileInputStream(wb));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    // Getter and setter

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
