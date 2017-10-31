package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Person;
import de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy;

import java.util.List;

public interface ApplicantService {

    List<Applicant> listApplicants();

    Long countEntries();

    Applicant loadApplicant(long applicantId);

    void save(Applicant applicant);

    void delete(Long applicantId) throws Exception;

    List<Applicant> filterApplicantList(String selectedFirstName, String selectedLastName, FieldOfStudy fieldOfStudy);
}
