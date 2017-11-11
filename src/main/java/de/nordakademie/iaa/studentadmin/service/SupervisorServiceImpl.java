package de.nordakademie.iaa.studentadmin.service;

import de.nordakademie.iaa.studentadmin.dao.SupervisorDAO;
import de.nordakademie.iaa.studentadmin.model.ProfilePicture;
import de.nordakademie.iaa.studentadmin.model.Supervisor;
import de.nordakademie.iaa.studentadmin.utilities.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the supervisor service.
 *
 * @author Lennart Meincke
 */
@Component
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class SupervisorServiceImpl implements SupervisorService {

    /**
     * The supervisor doa.
     */
    @Autowired
    private SupervisorDAO supervisorDAO;

    @Override
    public Long saveSupervisor(Supervisor supervisor) {
        return supervisorDAO.save(supervisor);
    }

    @Override
    public Supervisor loadSupervisor(Long id) {
        return supervisorDAO.load(id);
    }

    @Override
    public void delete(Long supervisorId) throws EntityNotFoundException {
        Supervisor supervisor = loadSupervisor(supervisorId);
        if (supervisor == null) {
            throw new EntityNotFoundException();
        } else {
            supervisorDAO.delete(supervisor);
        }
    }

    public void setSupervisorDAO(SupervisorDAO supervisorDAO) {
        this.supervisorDAO = supervisorDAO;
    }
}
