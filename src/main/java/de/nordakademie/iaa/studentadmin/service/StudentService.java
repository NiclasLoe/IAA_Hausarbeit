package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.*;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

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

    List<Student> listStudentsByManiple(FieldOfStudy fieldOfStudy, Integer year);

    List<Student> filterActiveStudentList(String selectedFirstName, String selectedLastName, String selectedStudentId, Company company, Century century, FieldOfStudy fieldOfStudy, String year);

    List<Student> filterAlumniList(String selectedFirstName, String selectedLastName,
                                          String selectedStudentId, Company company, Century century,
                                          FieldOfStudy selectedFieldOfStudy, String selectedYear);

    List<Student> listStudentsByCompany(Company companyTemp);

    void addProfilePic(Student student, ProfilePicture profilePicture);
}
