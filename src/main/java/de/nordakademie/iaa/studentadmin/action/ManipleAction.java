package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.ManipleService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import de.nordakademie.iaa.studentadmin.utilities.ExcelCreator;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ManipleAction extends ActionSupport {

    private ManipleService manipleService;
    private StudentService studentService;
    private List<String> manipleList;
    private String maniple;
    private InputStream fileInputStream;

    public String listAllManiple() {
        manipleList = manipleService.getAvailableManiple();
        return SUCCESS;
    }

    public String downloadResultList() throws Exception {


        FieldOfStudy fieldOfStudy = manipleService.returnFieldOfStudy(maniple);
        Integer year = manipleService.returnYear(maniple);
        String fieldOfStudyString = "" + fieldOfStudy;


        ExcelCreator excelCreator = new ExcelCreator();

        List<Student> students = studentService.listStudentsByManiple(fieldOfStudy, year);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.addAll(students);
        HSSFWorkbook wb = excelCreator.createResultList(studentList, fieldOfStudyString, year);

        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            wb.write(baos);
            setFileInputStream(new ByteArrayInputStream(baos.toByteArray()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

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
