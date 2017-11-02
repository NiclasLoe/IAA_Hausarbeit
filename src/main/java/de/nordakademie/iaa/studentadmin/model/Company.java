package de.nordakademie.iaa.studentadmin.model;

import javax.persistence.*;

/**
 * Company entity.
 *
 * @author Niclas Loeding
 */
@Entity
public class Company {

    /**
     * The identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * First part of the company name.
     */
    @Column(name = "COMPANY_NAME_1", nullable = false)
    private String companyName1;
    /**
     * Second part of the company name.
     */
    @Column(name = "COMPANY_NAME_2", nullable = true)
    private String companyName2;
    /**
     * The short company name.
     */
    @Column(name = "SHORT_NAME", nullable = false)
    private String shortName;
    /**
     * The contact person.
     */
    @Column(name = "CONTACT_PERSON", nullable = false)
    private String contactPerson;
    /**
     * The street name.
     */
    @Column(name = "STREET_NAME", nullable = false)
    private String streetName;
    /**
     * The house number.
     */
    @Column(name = "HOUSE_NUMBER", nullable = false)
    private String houseNumber;
    /**
     * The city.
     */
    @Column(name = "CITY", nullable = false)
    private String city;
    /**
     * The postal code.
     */
    @Column(name = "POSTAL_CODE", nullable = false)
    private Integer postalCode;
    /**
     * The phone number.
     */
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
    /**
     * The fax number.
     */
    @Column(name = "FAX_NUMBER", nullable = false)
    private String faxNumber;
    /**
     * The mail address.
     */
    @Column(name = "MAIL_ADDRESS", nullable = false)
    private String mailAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName1() {
        return companyName1;
    }

    public void setCompanyName1(String companyName1) {
        this.companyName1 = companyName1;
    }

    public String getCompanyName2() {
        return companyName2;
    }

    public void setCompanyName2(String companyName2) {
        this.companyName2 = companyName2;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
