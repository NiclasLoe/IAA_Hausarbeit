package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.util.ArrayList;

/**
 * Class that provides numbers regarding database entries.
 *
 * @author Niclas Loeding
 */
public class CountDatabaseEntries implements Action {
    /**
     * The student service.
     */
    private StudentService studentService;
    /**
     * The applicant service.
     */
    private ApplicantService applicantService;
    /**
     * List containing the number of database entries.
     */
    private ArrayList<Long> quantityList;

    /**
     * Methods counts applicant, student and alumni entries from the database.
     *
     * @return Struts outcome
     */
    @Override
    public String execute() {
        Long applicantCount = applicantService.countEntries();
        Long enrolledStudentCount = studentService.countEnrolledStudents();
        Long alumniCount = studentService.countAlumni();
        quantityList = new ArrayList<>();
        quantityList.add(applicantCount);
        quantityList.add(enrolledStudentCount);
        quantityList.add(alumniCount);
        return SUCCESS;
    }

    // Getter and setter

    public ArrayList<Long> getQuantityList() {
        return quantityList;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setApplicantService(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
}
