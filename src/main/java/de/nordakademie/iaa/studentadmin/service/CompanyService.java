package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Company;

import java.util.List;

/**
 * Interface for the company service.
 *
 * @author Niclas Loeding
 */
public interface CompanyService {

    /**
     * List all companies.
     *
     * @return List of companies.
     */
    List<Company> listCompanies();

    /**
     * Load a company by its identifier.
     *
     * @param companyId The company's identifier.
     * @return The found entity.
     */
    Company loadCompany(Long companyId);

    /**
     * Save a company to database.
     *
     * @param company The given company.
     */
    void save(Company company);
}
