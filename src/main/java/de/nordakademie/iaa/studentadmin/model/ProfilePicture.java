package de.nordakademie.iaa.studentadmin.model;

import sun.misc.BASE64Encoder;

import javax.persistence.*;

@Entity
public class ProfilePicture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, columnDefinition = "mediumblob")
    private byte[] image;
    @Transient
    private String imageString;

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
        BASE64Encoder base64Encoder = new BASE64Encoder();
        StringBuilder imageString = new StringBuilder();
        imageString.append("data:image/*;base64,");
        imageString.append(base64Encoder.encode(image));
        return imageString.toString();
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }
}
