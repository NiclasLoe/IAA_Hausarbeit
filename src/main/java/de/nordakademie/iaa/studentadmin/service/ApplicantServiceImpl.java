package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.ApplicantDAO;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Document;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Applicant service implementation.
 *
 * @author Lennart Meincke
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Component
public class ApplicantServiceImpl implements ApplicantService {

    /**
     * The applicant DAO.
     */
    @Autowired
    private ApplicantDAO applicantDAO;

    @Override
    public List<Applicant> listApplicants() {
        return applicantDAO.findApplicants(null, null, null);
    }

    @Override
    public Long countEntries() {
        return applicantDAO.countEntries();
    }

    @Override
    public Applicant loadApplicant(long id) {
        return applicantDAO.load(id);
    }

    @Override
    public void save(Applicant applicant) {
        applicantDAO.save(applicant);
    }

    @Override
    public void delete(Long applicantId) throws EntityNotFoundException {
        Applicant applicant = loadApplicant(applicantId);
        if (applicant == null) {
            throw new EntityNotFoundException();
        } else {
            applicantDAO.delete(applicant);
        }
    }

    @Override
    public List<Applicant> filterApplicantList(String selectedFirstName, String selectedLastName, FieldOfStudy selectedFieldOfStudy) {
        String firstName = null;
        String lastName = null;

        if (!selectedFirstName.equals("")) {
            firstName = selectedFirstName;
        }
        if (!selectedLastName.equals("")) {
            lastName = selectedLastName;
        }

        return applicantDAO.
                findApplicants(firstName, lastName, selectedFieldOfStudy);
    }

    @Override
    public void addDocument(Applicant applicant, Document document) {
        applicant.setDocument(document);
        applicantDAO.save(applicant);
    }

    // Getter and setter

    public void setApplicantDAO(ApplicantDAO applicantDAO) {
        this.applicantDAO = applicantDAO;
    }
}




