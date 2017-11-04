package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.DocumentDAO;
import de.nordakademie.iaa.studentadmin.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public Long saveNewDocument(byte[] fileContent, String fileName) {
        Document document = new Document();
        document.setFile(fileContent);
        document.setFileName(fileName);
        return documentDAO.save(document);
    }

    @Override
    public Document loadDocument(Long documentId) {
        return documentDAO.loadById(documentId);
    }
}
