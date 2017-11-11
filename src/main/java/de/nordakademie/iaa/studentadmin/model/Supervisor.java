package de.nordakademie.iaa.studentadmin.model;

import javax.persistence.*;

/**
 * Supervisor entity.
 *
 * @author Niclas Loeding
 */
@Entity
public class Supervisor {

    /**
     * The identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * The first name.
     */
    @Column(nullable = false)
    private String firstName;
    /**
     * The last name.
     */
    @Column(nullable = false)
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
