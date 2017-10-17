package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.ApplicantDAO;
import de.nordakademie.iaa.studentadmin.model.Person;

import java.util.List;

public class ApplicantServiceImpl implements ApplicantService {

    private ApplicantDAO applicantDAO;

    @Override
    public List<Person> listApplicants() {
        return applicantDAO.findAll();
    }
}
