package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Document;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.ApplicantService;
import de.nordakademie.iaa.studentadmin.service.DocumentService;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.io.*;

public class DownloadAction extends ActionSupport {

    /**
     * The input stream.
     */
    private InputStream inputStream;
    /**
     * The file's name.
     */
    private String fileName;
    /**
     * The related student.
     */
    private Student student;
    /**
     * The student service.
     */
    private StudentService studentService;
    /**
     * The document service.
     */
    private DocumentService documentService;
    /**
     * The document's data type.
     */
    private String dataType;
    /**
     * The related applicant.
     */
    private Applicant applicant;
    /**
     * The applicant service.
     */
    private ApplicantService applicantService;

    /**
     * Method to download document stored in student.
     *
     * @return Struts outcome.
     */
    public String downloadStudentDocument() {
        Student studentTemp = studentService.loadStudent(student.getId());
        Document documentTemp = documentService.loadDocument(studentTemp.getDocument().getId());
        setInputStream(createByteArrayInputStream(documentTemp));
        return SUCCESS;
    }

    /**
     * Method to download document stored in applicant.
     *
     * @return Struts outcome.
     */
    public String downloadApplicantDocument() throws Exception {
        Applicant applicantTemp = applicantService.loadApplicant(applicant.getId());
        Document documentTemp = documentService.loadDocument(applicantTemp.getDocument().getId());
        setInputStream(createByteArrayInputStream(documentTemp));
        return SUCCESS;
    }

    /**
     * Method to transform document to exporting file.
     *
     * @return ByteArrayInputStream to export file.
     */
    private ByteArrayInputStream createByteArrayInputStream(Document document) {
        byte content[] = document.getFile();
        String suffix = document.getSuffix();
        fileName = document.getFileName() + suffix;
        dataType = document.getDataType();
        return new ByteArrayInputStream(content);
    }

    // Getter and setter

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setApplicantService(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
