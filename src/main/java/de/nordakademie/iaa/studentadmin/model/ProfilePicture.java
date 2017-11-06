package de.nordakademie.iaa.studentadmin.model;

import de.nordakademie.iaa.studentadmin.utilities.FileConverterUtil;

import javax.persistence.*;

/**
 * Profile picture entity.
 *
 * @author Niclas Loeding
 */
@Entity
public class ProfilePicture {

    /**
     * The identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * The data as byte array.
     */
    @Column(nullable = false, columnDefinition = "mediumblob")
    private byte[] image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageString() {
        FileConverterUtil fileConverterUtil = new FileConverterUtil();
        return fileConverterUtil.byteToString(image, "image/*");
    }
}
