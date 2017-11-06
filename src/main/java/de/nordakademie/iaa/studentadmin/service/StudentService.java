package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.*;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

import java.util.List;

/**
 * Interface of the student service.
 *
 * @author Niclas Loeding
 */
public interface StudentService {

    /**
     * List all enrolled students.
     *
     * @return List of students.
     */
    List<Student> listEnrolledStudent();

    /**
     * Count all alumni in database.
     *
     * @return Alumni count.
     */
    Long countAlumni();

    /**
     * Count all students in database.
     *
     * @return Student count.
     */
    Long countEnrolledStudents();

    /**
     * List all alumni.
     *
     * @return List of students.
     */
    List<Student> listAlumni();

    /**
     * Save a student.
     *
     * @param student The given
     * @param company The company of a student.
     * @param century The century of a student.
     */
    void saveStudent(Student student, Company company, Century century);

    /**
     * Load student by its identifier.
     *
     * @param personId The given identifier.
     * @return The found entity.
     */
    Student loadStudent(long personId);

    /**
     * Add a new student
     *
     * @param student The given
     * @param company The company of a student.
     * @param century The century of a student.
     */
    void saveNewStudent(Student student, Company company, Century century);

    /**
     * Change student status to ALUMNI.
     *
     * @param personId
     */
    void endActiveStudies(Long personId);

    /**
     * Change student status to DROPPED_OUT.
     *
     * @param personId
     */
    void exmatriculateStudent(Long personId);

    /**
     * List all students that belong to a century.
     *
     * @param century The century criteria.
     * @return List of students.
     */
    List<Student> listStudentsByCentury(Century century);

    /**
     * List all students by maniple (year and field of study).
     *
     * @param fieldOfStudy The field of study criteria.
     * @param year         The year criteria.
     * @return List of students.
     */
    List<Student> listStudentsByManiple(FieldOfStudy fieldOfStudy, Integer year);

    /**
     * Filter the list of students by certain criteria.
     *
     * @param selectedFirstName The first name criteria.
     * @param selectedLastName  The last name criteria.
     * @param selectedStudentId The student id criteria.
     * @param company           The company criteria.
     * @param century           The century criteria.
     * @param fieldOfStudy      The field of study criteria.
     * @param year              The year criteria.
     * @return List of students.
     */
    List<Student> filterActiveStudentList(String selectedFirstName, String selectedLastName,
                                          String selectedStudentId, Company company, Century century,
                                          FieldOfStudy fieldOfStudy, String year);

    /**
     * Filter the list of alumni by certain criteria.
     *
     * @param selectedFirstName    The first name criteria.
     * @param selectedLastName     The last name criteria.
     * @param selectedStudentId    The student id criteria.
     * @param company              The company criteria.
     * @param century              The century criteria.
     * @param selectedFieldOfStudy The field of study criteria.
     * @param selectedYear         The year criteria.
     * @return List of students.
     */
    List<Student> filterAlumniList(String selectedFirstName, String selectedLastName,
                                   String selectedStudentId, Company company, Century century,
                                   FieldOfStudy selectedFieldOfStudy, String selectedYear);

    /**
     * List all active students that belong to a company.
     *
     * @param company The given company.
     * @return List of students.
     */
    List<Student> listStudentsByCompany(Company company);

    /**
     * Add a profile picture.
     *
     * @param student        The given student.
     * @param profilePicture The profile picture to be added.
     */
    void addProfilePic(Student student, ProfilePicture profilePicture);

    /**
     * Add document to student.
     *
     * @param student  The given student.
     * @param document The document to be added.
     */
    void addDocument(Student student, Document document);
}
