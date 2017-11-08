package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.StudentDAO;
import de.nordakademie.iaa.studentadmin.model.*;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import de.nordakademie.iaa.studentadmin.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Student service implementation.
 *
 * @author Niclas Loeding
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Component
public class StudentServiceImpl implements StudentService {

    /**
     * The student DAO.
     */
    @Autowired
    private StudentDAO studentDAO;

    /**
     * The start for the username.
     */
    private final Integer firstUsername = 10000;

    /**
     * The start for the username.
     */
    private final Integer firstStudentId = 1000;

    /**
     * The domain name for the user email address.
     */
    private final String domain = "@nordakademie.de";

    @Override
    public List<Student> listEnrolledStudent() {
        return studentDAO.findStudents(Status.ENROLLED, null, null, null, null,
                null, null, null, null);
    }

    @Override
    public Long countEnrolledStudents() {
        return studentDAO.countEntries(Status.ENROLLED);
    }

    @Override
    public List<Student> listAlumni() {
        return studentDAO.
                findStudents(Status.ALUMNI, null, null, null, null,
                        null, null, null, null);
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
        return studentDAO.
                findStudents(Status.ENROLLED, century, null, null, null,
                        null, null, null, null);
    }

    @Override
    public Student loadStudent(long personId) {
        return studentDAO.load(personId);
    }

    @Override
    public void saveNewStudent(Student student, Company company, Century century, Document document) {
        student.setStatus(Status.ENROLLED);
        student.setStudentId(createStudentId());
        student.setUserEmail(createUserMail(student));
        student.setUsername(createUserName());
        student.setCentury(century);
        student.setCompany(company);
        student.setDocument(document);
        studentDAO.saveStudent(student);
    }

    @Override
    public List<Student> listStudentsByManiple(FieldOfStudy fieldOfStudy, Integer year) {
        return studentDAO.
                findStudents(Status.ENROLLED, null, fieldOfStudy, year, null,
                        null, null, null, null);
    }

    @Override
    public void addProfilePic(Student student, ProfilePicture profilePicture) {
        student.setProfilePicture(profilePicture);
        studentDAO.saveStudent(student);
    }

    @Override
    public void addDocument(Student student, Document document) {
        student.setDocument(document);
        studentDAO.saveStudent(student);
    }

    @Override
    public List<Student> filterDroppedOutList(String selectedFirstName, String selectedLastName,
                                              String selectedStudentId, Company company, Century century,
                                              FieldOfStudy selectedFieldOfStudy, String selectedYear) {
        String firstName = null;
        String lastName = null;
        Integer studentId = null;
        Integer year = null;
        FieldOfStudy fieldOfStudy = null;

        if (!selectedFirstName.equals("")) {
            firstName = selectedFirstName;
        }
        if (!selectedLastName.equals("")) {
            lastName = selectedLastName;
        }
        if (!selectedStudentId.equals("")) {
            studentId = Integer.parseInt(selectedStudentId);
        }

        if (century == null) {
            if (!selectedYear.equals("")) {
                year = Integer.parseInt(selectedYear);
            }
            fieldOfStudy = selectedFieldOfStudy;
        }

        return studentDAO.
                findStudents(Status.DROPPED_OUT, century, fieldOfStudy, year, null,
                        company, firstName, lastName, studentId);
    }

    @Override
    public List<Student> filterActiveStudentList(String selectedFirstName, String selectedLastName,
                                                 String selectedStudentId, Company company, Century century,
                                                 FieldOfStudy selectedFieldOfStudy, String selectedYear) {
        String firstName = null;
        String lastName = null;
        Integer studentId = null;
        Integer year = null;
        FieldOfStudy fieldOfStudy = null;

        if (!selectedFirstName.equals("")) {
            firstName = selectedFirstName;
        }
        if (!selectedLastName.equals("")) {
            lastName = selectedLastName;
        }
        if (!selectedStudentId.equals("")) {
            studentId = Integer.parseInt(selectedStudentId);
        }

        if (century == null) {
            if (!selectedYear.equals("")) {
                year = Integer.parseInt(selectedYear);
            }
            fieldOfStudy = selectedFieldOfStudy;
        }

        return studentDAO.
                findStudents(Status.ENROLLED, century, fieldOfStudy, year, null,
                        company, firstName, lastName, studentId);
    }

    @Override
    public List<Student> filterAlumniList(String selectedFirstName, String selectedLastName,
                                                 String selectedStudentId, Company company, Century century,
                                                 FieldOfStudy selectedFieldOfStudy, String selectedYear) {
        String firstName = null;
        String lastName = null;
        Integer studentId = null;
        Integer year = null;
        FieldOfStudy fieldOfStudy = null;

        if (!selectedFirstName.equals("")) {
            firstName = selectedFirstName;
        }
        if (!selectedLastName.equals("")) {
            lastName = selectedLastName;
        }
        if (!selectedStudentId.equals("")) {
            studentId = Integer.parseInt(selectedStudentId);
        }

        if (century == null) {
            if (!selectedYear.equals("") ) {
                year = Integer.parseInt(selectedYear);
            }
            fieldOfStudy = selectedFieldOfStudy;
        }

        return studentDAO.
                findStudents(Status.ALUMNI, century, fieldOfStudy, year, null,
                        company, firstName, lastName, studentId);
    }

    @Override
    public List<Student> listStudentsByCompany(Company company) {
        return studentDAO.
                findStudents(Status.ENROLLED, null, null,
                        null, null, company, null,
                        null, null);
    }

    /**
     * Create username for new student.
     *
     * @return The created username.
     */
    private Integer createUserName() {
        Integer studentId = (int) (long) studentDAO.countEntries(null);
        studentId = studentId + firstUsername;
        return studentId;
    }

    /**
     * Create student id for new student.
     *
     * @return The created student id.
     */
    private Integer createStudentId() {
        Integer studentId = (int) (long) studentDAO.countEntries(null);
        studentId = studentId + firstStudentId;
        return studentId;
    }

    /**
     * Method to create an user email address.
     *
     * @param student The related student.
     * @return User mail address.
     */
    private String createUserMail(Student student) {
        // Create the user email address
        String lastName = student.getLastName();
        String firstName = student.getFirstName();
        String prefix = firstName + "." + lastName;
        prefix = prefix.replace(" ", "_");
        prefix = prefix.replace("ö", "oe");
        prefix = prefix.replace("ä", "ae");
        prefix = prefix.replace("ü", "ue");
        prefix = prefix.replace("ß", "ss");

        String userMail = prefix + domain;

        // Load student by user email
        List<Student> studentListTemp = studentDAO.
                findStudents(null, null, null, null, userMail,
                        null, null, null, null);

        // Check whether student with this userMail exists
        if (!studentListTemp.isEmpty()) {
            // Add number to the mail until it's unique
            Integer count = 1;
            while (!(studentListTemp.isEmpty())) {
                userMail = prefix + count + domain;
                count = count + 1;
                studentListTemp = studentDAO.
                        findStudents(null, null, null, null, userMail,
                                null, null, null, null);
            }
        }
        return userMail;
    }

    @Override
    public List<Student> listDroppedOut() {
        return studentDAO.findStudents(Status.DROPPED_OUT, null, null,
                null, null, null, null,
                null, null);
    }

    @Override
    public void reEnrollDroppedOut(Long studentId) {
        Student student = studentDAO.load(studentId);
        student.setStatus(Status.ENROLLED);
        studentDAO.saveStudent(student);
    }

    // Getter and setter

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

}

