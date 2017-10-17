package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.ApplicantDAO;
import de.nordakademie.iaa.studentadmin.model.Applicant;
import de.nordakademie.iaa.studentadmin.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantDAO applicantDAO;

    @Override
    public List<Person> listApplicants() {
        return applicantDAO.findAll();
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
    public void delete(Long applicantId) throws Exception {
        Applicant applicant = loadApplicant(applicantId);
        if (applicant == null) {
            throw new EntityNotFoundException();
        } else {
            applicantDAO.delete(applicant);
        }
    }
}




