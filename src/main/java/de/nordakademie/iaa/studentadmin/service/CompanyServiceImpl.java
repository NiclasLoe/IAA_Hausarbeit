package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.CompanyDAO;
import de.nordakademie.iaa.studentadmin.model.Company;
import de.nordakademie.iaa.studentadmin.model.Supervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Company service implementation.
 *
 * @author Lennart Meincke
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Component
public class CompanyServiceImpl implements CompanyService {

    /**
     * The company DAO.
     */
    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public List<Company> listCompanies() {
        return companyDAO.listAll();
    }

    @Override
    public Company loadCompany(Long companyId) {
        return companyDAO.loadByID(companyId);
    }

    @Override
    public void save(Company company) {
        companyDAO.save(company);
    }

    @Override
    public void removeSupervisor(Company company, Supervisor supervisor) {
        List<Supervisor> supervisorList = company.getSupervisor();
        List<Supervisor> newSupervisorList = new ArrayList<>();
        for (int i = 0; i < supervisorList.size(); i++) {
            if (!supervisorList.get(i).getId().equals(supervisor.getId())) {
                newSupervisorList.add(supervisorList.get(i));
            }
        }
        company.setSupervisor(newSupervisorList);
        save(company);

    }
}
