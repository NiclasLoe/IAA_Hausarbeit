package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Document;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;
/**
 * Interface for the document service.
 *
 * @author Niclas Loeding
 */
public interface DocumentService {

    /**
     * Load document by given identifier.
     *
     * @param documentId The document's identifier.
     * @return The found entity.
     */
    Document loadDocument(Long documentId);

    /**
     * Create and save new document.
     *
     * @param fileContent The content of the file.
     * @param fileName The name of the file.
     * @param dataType The data type of the file.
     * @return The document's identifier.
     */
    Long saveNewDocument(byte[] fileContent, String fileName, String dataType);

    /**
     * Delete a given document.
     *
     * @param id The document's identifier.
     * @throws EntityNotFoundException Exception in case entity not available anymore.
     */
    void deleteDocument(Long id) throws EntityNotFoundException;
}
