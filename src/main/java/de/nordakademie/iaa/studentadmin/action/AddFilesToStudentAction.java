package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.Document;
import de.nordakademie.iaa.studentadmin.model.ProfilePicture;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.DocumentService;
import de.nordakademie.iaa.studentadmin.service.ProfilePictureService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import de.nordakademie.iaa.studentadmin.utilities.FileConverterUtil;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import java.io.File;
import java.io.IOException;

public class AddFilesToStudentAction extends ActionSupport {
    /**
     * The student service.
     */
    private StudentService studentService;
    /**
     * The student to picture is added to.
     */
    private Student student;
    /**
     * The profile picture service.
     */
    private ProfilePictureService profilePictureService;
    /**
     * The document service;
     */
    private DocumentService documentService;
    /**
     * The name of the uploaded file.
     */
    private String fileFileName;
    /**
     * The content type of the uploaded file.
     */
    private String fileContentType;
    /**
     * The uploaded file.
     */
    private File file;
    /**
     * The preferred file name.
      */
    private String selectedFileName;

    /**
     * Method to add a profile pic to a student.
     *
     * @return Struts outcome.
     */
    public String addProfilePictureToStudent() {
        FileConverterUtil fileConverterUtil = new FileConverterUtil();
        // Load student by id
        Long id = student.getId();
        student = studentService.loadStudent(id);

        try {
            // Prepare byte array
            String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");
            File fileToCreate = new File(filePath, fileFileName);
            FileUtils.copyFile(this.file, fileToCreate);

            byte fileContent[] = fileConverterUtil.contentInByte(fileToCreate);

            // Save profile picture to database
            Long photoId = profilePictureService.saveNewImage(fileContent);
            ProfilePicture profilePictureTemp = profilePictureService.loadImage(photoId);

            // Add profile picture to student
            studentService.addProfilePic(student, profilePictureTemp);
        } catch (IOException e) {
            e.printStackTrace();
            addActionError(e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    /**
     * Method to add a profile pic to a student.
     *
     * @return Struts outcome.
     */
    public String addDocumentToStudent() {
        FileConverterUtil fileConverterUtil = new FileConverterUtil();
        // Load student by id
        Long id = student.getId();
        student = studentService.loadStudent(id);

        try {
            // Prepare byte array
            String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("documents");
            File fileToCreate = new File(filePath, fileFileName);
            FileUtils.copyFile(this.file, fileToCreate);

            byte fileContent[] = fileConverterUtil.contentInByte(fileToCreate);

            // Save profile picture to database
            Long documentId = documentService.saveNewDocument(fileContent, selectedFileName);
            Document documentTemp = documentService.loadDocument(documentId);

            // Add profile picture to student
            studentService.addDocument(student, documentTemp);
        } catch (IOException e) {
            e.printStackTrace();
            addActionError(e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    // Getter and setter

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ProfilePictureService getProfilePictureService() {
        return profilePictureService;
    }

    public void setProfilePictureService(ProfilePictureService profilePictureService) {
        this.profilePictureService = profilePictureService;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileName) {
        this.fileFileName = fileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getSelectedFileName() {
        return selectedFileName;
    }

    public void setSelectedFileName(String selectedFileName) {
        this.selectedFileName = selectedFileName;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
}

