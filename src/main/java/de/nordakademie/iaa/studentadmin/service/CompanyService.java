package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Supervisor;

import java.util.List;

/**
 * Interface for the company service.
 *
 * @author Lennart Meincke
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

    /**
     * Removes a supervisor from a company.
     *
     * @param company The current company.
     * @param supervisor The supervisor to be removed.
     */
    void removeSupervisor(Company company, Supervisor supervisor);
}
