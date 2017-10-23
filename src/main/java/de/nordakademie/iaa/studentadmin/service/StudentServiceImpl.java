package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.StudentDAO;
import de.nordakademie.iaa.studentadmin.model.Status;
import de.nordakademie.iaa.studentadmin.model.Student;
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
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    public Student loadStudent(long personId) {
        return studentDAO.load(personId);
    }

    @Override
    public void saveNewStudent(Student student) {
        student.setStatus(Status.ENROLLED);
        studentDAO.saveStudent(student);
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
