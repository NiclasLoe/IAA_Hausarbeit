package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Century;
import de.nordakademie.iaa.studentadmin.model.CenturyId;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listEnrolledStudent();

    Long countAlumni();

    Long countEnrolledStudents();

    List<Student> listAlumni();

    void saveStudent(Student student, Company company, Century century);

    Student loadStudent(long personId);

    void saveNewStudent(Student student, Company company, Century century);

    void endActiveStudies(Long personId);

    void exmatriculateStudent(Long personId);

    List<Student> listStudentsByCentury(Century century);
}
