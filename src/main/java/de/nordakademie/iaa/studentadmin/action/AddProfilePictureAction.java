package de.nordakademie.iaa.studentadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.iaa.studentadmin.model.ProfilePicture;
import de.nordakademie.iaa.studentadmin.model.Student;
import de.nordakademie.iaa.studentadmin.service.ProfilePictureService;
import de.nordakademie.iaa.studentadmin.service.StudentService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AddProfilePictureAction extends ActionSupport {
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
     * The name of the uploaded file.
     */
    private String userImageFileName;
    /**
     * The content type of the uploaded file.
     */
    private String userImageContentType;
    /**
     * The uploaded file.
     */
    private File userImage;

    /**
     * Method to add a profile pic to a student.
     *
     * @return Struts outcome.
     */
    public String addProfilePictureToStudent() {
        Long id = student.getId();
        student = studentService.loadStudent(id);
        try {
            String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");
            File fileToCreate = new File(filePath, userImageFileName);
            FileUtils.copyFile(this.userImage, fileToCreate);

            FileInputStream fileInputStream = new FileInputStream(fileToCreate);
            byte fileContent[] = new byte[(int) fileToCreate.length()];
            fileInputStream.read(fileContent);
            fileInputStream.close();

            ProfilePicture profilePicture = new ProfilePicture();
            profilePicture.setImage(fileContent);
            Long photoId = profilePictureService.saveImage(profilePicture);
            ProfilePicture profilePictureTemp = profilePictureService.loadImage(photoId);
            studentService.addProfilePic(student, profilePictureTemp);
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

    public String getUserImageFileName() {
        return userImageFileName;
    }

    public void setUserImageFileName(String userImageFileName) {
        this.userImageFileName = userImageFileName;
    }

    public File getUserImage() {
        return userImage;
    }

    public void setUserImage(File userImage) {
        this.userImage = userImage;
    }

    public String getUserImageContentType() {
        return userImageContentType;
    }

    public void setUserImageContentType(String userImageContentType) {
        this.userImageContentType = userImageContentType;
    }
}

