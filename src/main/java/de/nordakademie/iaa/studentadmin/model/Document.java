package de.nordakademie.iaa.studentadmin.model;

import javax.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, columnDefinition = "mediumblob")
    private byte[] file;
    @Column(nullable = false)
    private String fileName;
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
