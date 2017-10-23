package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.util.List;

public class ShowStudentListAction extends ActionSupport {

    private StudentService studentService;
    private List<Student> studentList;

    public String listEnrolledStudents() {
        studentList = studentService.listEnrolledStudent();
        return SUCCESS;
    }

    public String listAlumni() {
        studentList = studentService.listAlumni();
        return SUCCESS;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
