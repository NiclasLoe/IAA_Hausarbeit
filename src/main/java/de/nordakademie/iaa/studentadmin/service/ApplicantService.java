package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Document;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

import java.util.List;

/**
 * Interface for the applicant service.
 *
 * @author Lennart Meincke
 */
public interface ApplicantService {

    /**
     * Load all applicants.
     *
     * @return List of applicants.
     */
    List<Applicant> listApplicants();

    /**
     * Count entries stored in database.
     *
     * @return Entry count.
     */
    Long countEntries();

    /**
     * Load applicant by given identifier.
     *
     * @param applicantId The applicant's identifier.
     * @return The found entity.
     */
    Applicant loadApplicant(long applicantId);

    /**
     * Save a given applicant.
     *
     * @param applicant The given entity.
     */
    void save(Applicant applicant);

    /**
     * Method to delete an applicant by id.
     *
     * @param applicantId The applicant's identifier.
     * @throws EntityNotFoundException Exception in case entity not available anymore.
     */
    void delete(Long applicantId) throws EntityNotFoundException;

    /**
     * List applicants filtered by certain filter criteria.
     *
     * @param selectedFirstName The first name criteria.
     * @param selectedLastName  The last name criteria.
     * @param fieldOfStudy      The field of study criteria.
     * @return List of applicants.
     */
    List<Applicant> filterApplicantList(String selectedFirstName, String selectedLastName, FieldOfStudy fieldOfStudy);

    /**
     * Add document to an applicant.
     *
     * @param applicant    The given applicant.
     * @param documentTemp The document to be added to the applicant.
     */
    void addDocument(Applicant applicant, Document documentTemp);
}
