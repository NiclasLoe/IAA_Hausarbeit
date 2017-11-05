package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Document;

public interface DocumentService {

    Document loadDocument(Long documentId);

    Long saveNewDocument(byte[] fileContent, String fileName, String dataType);
}
