package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.StudentDAO;
import de.nordakademie.iaa.studentadmin.model.*;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import de.nordakademie.iaa.studentadmin.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> listEnrolledStudent() {
        return studentDAO.findStudents(Status.ENROLLED, null, null, null, null);
    }

    @Override
    public Long countEnrolledStudents() {
        return studentDAO.countEntries(Status.ENROLLED);
    }

    @Override
    public List<Student> listAlumni() {
        return studentDAO.findStudents(Status.ALUMNI, null, null, null, null);
    }

    @Override
    public Long countAlumni() {
        return studentDAO.countEntries(Status.ALUMNI);
    }

    @Override
    public void saveStudent(Student student, Company company, Century century) {
        student.setCompany(company);
        student.setCentury(century);
        studentDAO.saveStudent(student);
    }

    @Override
    public void endActiveStudies(Long personId) {
        Student student = studentDAO.load(personId);
        student.setStatus(Status.ALUMNI);
        studentDAO.saveStudent(student);
    }

    @Override
    public void exmatriculateStudent(Long personId) {
        Student student = studentDAO.load(personId);
        student.setStatus(Status.DROPPED_OUT);
        studentDAO.saveStudent(student);
    }

    @Override
    public List<Student> listStudentsByCentury(Century century) {
        return studentDAO.findStudents(null, century, null, null, null);
    }

    @Override
    public Student loadStudent(long personId) {
        return studentDAO.load(personId);
    }

    @Override
    public void saveNewStudent(Student student, Company company, Century century) {
        student.setStatus(Status.ENROLLED);
        student.setStudentId(createStudentId());
        student.setUserEmail(createUserMail(student));
        student.setUsername(createUserName());
        student.setCentury(century);
        student.setCompany(company);
        studentDAO.saveStudent(student);
    }

    private Integer createUserName() {
        Integer studentId = (int) (long) studentDAO.countEntries(null);
        studentId = studentId + 10000;
        return studentId;
    }

    @Override
    public List<Student> listStudentsByManiple(FieldOfStudy fieldOfStudy, Integer year) {
        return studentDAO.findStudents(null, null, fieldOfStudy, year, null);
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    private Integer createStudentId() {
        Integer studentId = (int) (long) studentDAO.countEntries(null);
        studentId = studentId + 1000;
        return studentId;
    }

    private String createUserMail(Student student) {
        String domain = "@nordakademie.de";
        String lastName = student.getLastName();
        lastName = lastName.replace(" ", "_");
        String firstName = student.getFirstName();
        firstName = firstName.replace(" ", "_");
        String userMail = firstName + "." + lastName + domain;
        List<Student> studentListTemp = studentDAO.findStudents(null, null, null, null, userMail);

        if (studentListTemp.isEmpty()) {
            return userMail;
        } else {
            Integer count = 1;
            while (!(studentListTemp.isEmpty())) {
                userMail = firstName + "." + lastName + count + domain;
                count = count + 1;
                studentListTemp = studentDAO.findStudents(null, null, null, null, userMail);
            }
        }

        return userMail;
    }
}