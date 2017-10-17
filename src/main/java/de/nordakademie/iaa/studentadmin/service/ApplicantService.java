package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Person;

import java.util.List;

public interface ApplicantService {

    List<Person> listApplicants();

    Long countEntries();

    Applicant loadApplicant(long applicantId);

    void save(Applicant applicant);

    void delete(Long applicantId) throws Exception;
}
