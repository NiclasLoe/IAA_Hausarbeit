package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Document;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

import java.util.List;

public interface ApplicantService {

    List<Applicant> listApplicants();

    Long countEntries();

    Applicant loadApplicant(long applicantId);

    void save(Applicant applicant);

    void delete(Long applicantId) throws EntityNotFoundException;

    List<Applicant> filterApplicantList(String selectedFirstName, String selectedLastName, FieldOfStudy fieldOfStudy);

    void addDocument(Applicant applicant, Document documentTemp);
}
