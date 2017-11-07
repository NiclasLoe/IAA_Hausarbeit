package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.util.List;

/**
 * Class that contain methods to make list of students available.
 *
 * @author Niclas Loeding
 */
public class ShowStudentListAction implements Action {

    /**
     * The student service.
     */
    private StudentService studentService;
    /**
     * The list of students.
     */
    private List<Student> studentList;

    /**
     * Empty execute method.
     *
     * @return Struts outcome.
     */
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    /**
     * Method to list all student with status "ENROLLED".
     *
     * @return Struts outcome.
     */
    public String listEnrolledStudents() {
        studentList = studentService.listEnrolledStudent();
        return SUCCESS;
    }

    /**
     * Method to list all students with status "ALUMNI".
     *
     * @return Struts outcome.
     */
    public String listAlumni() {
        studentList = studentService.listAlumni();
        return SUCCESS;
    }

    /**
     * Method to list all student with status "DROPPED_OUT".
     *
     * @return Struts outcome.
     */
    public String listDroppedOut() {
        studentList = studentService.listDroppedOut();
        return SUCCESS;
    }

    // Getter and setter

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


}