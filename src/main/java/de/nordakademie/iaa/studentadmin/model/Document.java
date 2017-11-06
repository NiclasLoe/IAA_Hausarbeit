package de.nordakademie.iaa.studentadmin.model;

import javax.persistence.*;

/**
 * Document entity.
 *
 * @author Niclas Loeding
 */
@Entity
public class Document {
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
    private byte[] file;
    /**
     * The file name.
     */
    @Column(nullable = false)
    private String fileName;
    /**
     * The data type as string.
     */
    @Column(nullable = false)
    private String dataType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getSuffix() {
        if (dataType.equals("application/pdf")) {
            return ".pdf";
        } else {
            if (dataType.equals("application/zip")) {
                return ".zip";
            }
        }
        return "";
    }
}
