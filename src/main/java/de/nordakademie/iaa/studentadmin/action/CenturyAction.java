package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.*;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.CenturyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

/**
 * Class that contains all action methods for centuries.
 *
 * @author Niclas Loeding
 */
public class CenturyAction extends ActionSupport {

    /**
     * The century service.
     */
    private CenturyService centuryService;
    /**
     * The century currently edited.
     */
    private Century century;
    /**
     * The century's identifier as String.
     */
    private String centuryString;
    /**
     * The student service.
     */
    private StudentService studentService;
    /**
     * The input stream to allow the download of the excel file.
     */
    private InputStream fileInputStream;

    /**
     * Validates whether a century is selected.
     */
    public void validateDownloadCenturyList() {
        if ((century == null) && (centuryString == null)) {
            addActionError(getText("error.selectCentury"));
        }
    }

    /**
     * Validates input before saving the currently edited century.
     */
    public void validateSaveCentury() {
        ActionSupportValidator validator = new ActionSupportValidator(this);
        validator.fieldValidated(Validator.isNull(century.getFieldOfStudy()),
                "century.fieldOfStudy", getText("error.fieldOfStudy"));
        validator.fieldValidated(Validator.isStringEmpty(century.getLetterCode()),
                "century.letterCode", getText("error.letterCode"));
        validator.fieldValidated(Validator.isNull(century.getYear()),
                "century.year", getText("error.year"));
    }

    /**
     * Saves the currently created century.
     *
     * @return Struts outcome
     */
    public String saveCentury() {
        centuryService.saveCentury(century);
        return SUCCESS;
    }

    /**
     * Method to download an excel file of the selected century.
     *
     * @return Struts outcome.
     */
    public String downloadCenturyList() {
        FileInputUtil fileInputUtil = new FileInputUtil();

        // Load Century by identifier (identifier as string)
        CenturyId centuryId = centuryService.returnId(centuryString);
        Century centuryTemp = centuryService.loadCentury(centuryId);

        // Get list of students for the workbook
        List<Student> students = studentService.listStudentsByCentury(centuryTemp);
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.addAll(students);

        // Create attendance list
        ExcelCreator excelCreator = new ExcelCreator();
        HSSFWorkbook wb = excelCreator.createAttendanceList(studentList, centuryTemp.getCenturyName());

        // try to export the created workbook
        try {
            setFileInputStream(fileInputUtil.createFileInputStream(wb));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    // Getter and setter

    public void setCentury(Century century) {
        this.century = century;
    }

    public Century getCentury() {
        return century;
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

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
}
