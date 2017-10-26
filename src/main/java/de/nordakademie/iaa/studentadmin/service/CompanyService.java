package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> listCompanies();

    Company loadCompany(Long companyId);

    void save(Company company);
}
