package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.ManipleService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import de.nordakademie.iaa.studentadmin.utilities.ExcelCreator;
import de.nordakademie.iaa.studentadmin.utilities.FileInputUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that contain methods to make result list available.
 *
 * @author Niclas Loeding
 */
public class ManipleAction extends ActionSupport {

    /**
     * The maniple service.
     */
    private ManipleService manipleService;
    /**
     * The student Service.
     */
    private StudentService studentService;
    /**
     * The list of available maniple.
     */
    private List<String> manipleList;
    /**
     * The selected maniple as String.
     */
    private String maniple;
    /**
     * The input stream to allow file export.
     */
    private InputStream fileInputStream;

    /**
     * Method to list all available maniple.
     *
     * @return Struts outcome.
     */
    public String listAllManiple() {
        manipleList = manipleService.getAvailableManiple();
        return SUCCESS;
    }

    /**
     * Method to download an excel file of the selected maniple.
     *
     * @return Struts outcome.
     */
    public String downloadResultList() {
        FileInputUtil fileInputUtil = new FileInputUtil();

        // Convert selected maniple into fields of year and field of study
        FieldOfStudy fieldOfStudy = manipleService.returnFieldOfStudy(maniple);
        Integer year = manipleService.returnYear(maniple);
        String fieldOfStudyString = "" + fieldOfStudy;

        // Load list of student for selected maniple
        List<Student> students = studentService.listStudentsByManiple(fieldOfStudy, year);
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.addAll(students);

        try {
            // Create and export result list
            ExcelCreator excelCreator = new ExcelCreator();
            HSSFWorkbook wb = excelCreator.createResultList(studentList, fieldOfStudyString, year);
            setFileInputStream(fileInputUtil.createFileInputStream(wb));
        } catch (Exception e) {
            addActionError(getText("error.fileCouldNotBeCreated"));
            return SUCCESS;
        }

        return SUCCESS;
    }

    // Getter and setter

    public String getManiple() {
        return maniple;
    }

    public void setManiple(String maniple) {
        this.maniple = maniple;
    }

    public void setManipleService(ManipleService manipleService) {
        this.manipleService = manipleService;
    }

    public List<String> getManipleList() {
        return manipleList;
    }

    public void setManipleList(List<String> manipleList) {
        this.manipleList = manipleList;
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
