package de.nordakademie.iaa.studentadmin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@IdClass(CenturyId.class)
public class Century {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    @OneToMany(mappedBy = "century", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "STUDENT_LIST")
    private List<Student> studentList = new ArrayList<>();
    @Id
    @Column(nullable = false, length = 4, name = "FIELD_OF_STUDY")
    private FieldOfStudy fieldOfStudy;
    @Id
    @Column(nullable = false, length = 2)
    private Integer year;
    @Id
    @Column(nullable = false, length = 1, name = "LETTER_CODE")
    private String letterCode;
    @Transient
    private String centuryName;

    public List<Student> getStudentList() {
        if (studentList == null) {
            studentList = new ArrayList<>();

        }
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public FieldOfStudy getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLetterCode() {
        return letterCode;
    }

    public void setLetterCode(String letterCode) {
        this.letterCode = letterCode;
    }

    public String getCenturyName() {
        String yearString = "" + year;
        yearString = yearString.substring(2, 4);
        centuryName = fieldOfStudy.getShortForm() + yearString + letterCode;
        return centuryName;
    }

    public void setCenturyName(String centuryName) {
        this.centuryName = centuryName;
    }
}
