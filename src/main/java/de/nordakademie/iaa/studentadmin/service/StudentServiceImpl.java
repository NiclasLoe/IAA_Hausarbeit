package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.StudentDAO;
import de.nordakademie.iaa.studentadmin.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> listEnrolledStudent() {
        return studentDAO.findStudents(Status.ENROLLED);
    }

    @Override
    public Long countEnrolledStudents() {
        return studentDAO.countEntriesByStatus(Status.ENROLLED);
    }

    @Override
    public List<Student> listAlumni() {
        return studentDAO.findStudents(Status.ALUMNI);
    }

    @Override
    public Long countAlumni() {
        return studentDAO.countEntriesByStatus(Status.ALUMNI);
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
        return studentDAO.findStudentsByCentury(century);
    }

    @Override
    public Student loadStudent(long personId) {
        return studentDAO.load(personId);
    }

    @Override
    public void saveNewStudent(Student student, Company company, Century century) {
        student.setStatus(Status.ENROLLED);
        student.setCentury(century);
        student.setCompany(company);
        studentDAO.saveStudent(student);
    }

    @Override
    public List<Student> listStudentsByManiple(FieldOfStudy fieldOfStudy, Integer year) {
        return studentDAO.findStudentsByManiple(fieldOfStudy, year);
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }


}
