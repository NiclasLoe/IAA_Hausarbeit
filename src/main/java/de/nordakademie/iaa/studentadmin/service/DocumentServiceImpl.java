package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.DocumentDAO;
import de.nordakademie.iaa.studentadmin.model.Document;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Document service implementation.
 *
 * @author Niclas Loeding
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Component
public class DocumentServiceImpl implements DocumentService {
    /**
     * The document DAO.
     */
    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public Long saveNewDocument(byte[] fileContent, String fileName, String dataType) {
        Document document = new Document();
        document.setFile(fileContent);
        document.setFileName(fileName);
        document.setDataType(dataType);
        return documentDAO.save(document);
    }

    @Override
    public Document loadDocument(Long documentId) {
        return documentDAO.loadById(documentId);
    }

    @Override
    public void deleteDocument(Long id) throws EntityNotFoundException {
        Document document = loadDocument(id);
        if (document == null) {
            throw new EntityNotFoundException();
        } else {
            documentDAO.delete(document);
        }
    }
}
