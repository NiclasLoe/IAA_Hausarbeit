package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listEnrolledStudent();

    Long countAlumni();

    Long countEnrolledStudents();

    List<Student> listAlumni();

    void saveStudent(Student student);

    Student loadStudent(long personId);

    void saveNewStudent(Student student);
}
