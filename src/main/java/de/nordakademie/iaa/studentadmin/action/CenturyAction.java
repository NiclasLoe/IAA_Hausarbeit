package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.utilities.ActionSupportValidator;
import de.nordakademie.iaa.studentadmin.utilities.CenturyId;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.CenturyService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import de.nordakademie.iaa.studentadmin.utilities.ExcelCreator;
import de.nordakademie.iaa.studentadmin.utilities.Validator;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

public class CenturyAction extends ActionSupport {

    private CenturyService centuryService;
    private Century century;
    private String centuryString;
    private StudentService studentService;
    private InputStream fileInputStream;

    public void validateDownloadCenturyList() {
        if ((century == null) && (centuryString == null)) {
            addActionError(getText("error.selectApplicant"));
        }
    }

    public void validateSaveCentury() {
        ActionSupportValidator validator = new ActionSupportValidator(this);
        validator.fieldValidated(Validator.isNull(century.getFieldOfStudy()), "century.fieldOfStudy", "Field of study is required.");
        validator.fieldValidated(Validator.isStringEmpty(century.getLetterCode()), "century.letterCode", "Letter code is required.");
        validator.fieldValidated(Validator.isNull(century.getYear()), "century.year", "Year is required.");
    }

    public String saveCentury() throws Exception {
        centuryService.saveCentury(century);
        return SUCCESS;
    }

    public String downloadCenturyList() throws Exception {
        CenturyId centuryId = centuryService.returnId(centuryString);
        Century centuryTemp = centuryService.loadCentury(centuryId);
        ExcelCreator excelCreator = new ExcelCreator();
        List<Student> students = studentService.listStudentsByCentury(centuryTemp);
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.addAll(students);

        HSSFWorkbook wb = excelCreator.createAttendanceList(studentList, centuryTemp.getCenturyName());


        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            wb.write(baos);
            setFileInputStream(new ByteArrayInputStream(baos.toByteArray()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

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
