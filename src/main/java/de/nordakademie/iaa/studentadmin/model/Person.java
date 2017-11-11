package de.nordakademie.iaa.studentadmin.model;

import de.nordakademie.iaa.studentadmin.utilities.Gender;
import de.nordakademie.iaa.studentadmin.utilities.Title;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.Date;

/**
 * Superclass for applicant and student entities.
 *
 * @author Niclas Loeding
 */
@MappedSuperclass
public abstract class Person {

    /**
     * The identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * The last name.
     */
    @Column(nullable = false)
    private String lastName;
    /**
     * The first name.
     */
    @Column(nullable = false)
    private String firstName;
    /**
     * The gender.
     */
    @Column(nullable = false)
    private Gender gender;
    /**
     * The title.
     */
    @Column(nullable = false)
    private Title title;
    /**
     * The date of birth.
     */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    /**
     * The birthplace.
     */
    @Column(nullable = false)
    private String birthplace;
    /**
     * The phone number.
     */
    @Column(nullable = false)
    private String phoneNumber;
    /**
     * The private mail address.
     */
    @Column(nullable = false)
    private String emailAddress;
    /**
     * The street name.
     */
    @Column(nullable = false)
    private String streetName;
    /**
     * The house number.
     */
    @Column(nullable = false)
    private String houseNumber;
    /**
     * The city.
     */
    @Column(nullable = false)
    private String city;
    /**
     * The postal code.
     */
    @Column(nullable = false)
    private String postalCode;
    /**
     * The stored file
     */
    @OneToOne
    private Document document;

    /**
     * The supervisor.
     */
    @ManyToOne
    private Supervisor supervisor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
