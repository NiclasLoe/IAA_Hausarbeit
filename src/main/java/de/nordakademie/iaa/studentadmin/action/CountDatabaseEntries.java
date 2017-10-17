package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.util.ArrayList;

public class CountDatabaseEntries implements Action {
    private StudentService studentService;
    private ApplicantService applicantService;
    private ArrayList<Long> quantityList;

    @Override
    public String execute() throws Exception {
        Long applicants = applicantService.countEntries();
        quantityList = new ArrayList<>();
        quantityList.add(applicants);
        quantityList.add((long) 2);
        quantityList.add((long) 4);
        return SUCCESS;
    }

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
