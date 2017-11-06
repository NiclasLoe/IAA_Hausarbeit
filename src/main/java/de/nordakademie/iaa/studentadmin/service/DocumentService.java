package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Document;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;

public interface DocumentService {

    Document loadDocument(Long documentId);

    Long saveNewDocument(byte[] fileContent, String fileName, String dataType);

    void deleteDocument(Long id) throws EntityNotFoundException;
}
