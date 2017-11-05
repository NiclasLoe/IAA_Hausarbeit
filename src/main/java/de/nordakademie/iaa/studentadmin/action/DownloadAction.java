package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Document;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.DocumentService;
import de.nordakademie.iaa.studentadmin.service.StudentService;

import java.io.*;

public class DownloadAction extends ActionSupport {

    private InputStream inputStream;
    private String fileName;
    private Student student;
    private StudentService studentService;
    private DocumentService documentService;
    private String dataType;

    public String downloadStudentDocument() {
        try {
            Student studentTemp = studentService.loadStudent(student.getId());
            Document documentTemp = documentService.loadDocument(studentTemp.getDocument().getId());
            byte content[] = documentTemp.getFile();
            String suffix = documentTemp.getSuffix();
            fileName = documentTemp.getFileName() + suffix;
            dataType = documentTemp.getDataType();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content);
            setInputStream(byteArrayInputStream);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }


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


}
