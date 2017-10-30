package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.util.List;

public class ShowStudentListAction implements Action {

    private StudentService studentService;
    private List<Student> studentList;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

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