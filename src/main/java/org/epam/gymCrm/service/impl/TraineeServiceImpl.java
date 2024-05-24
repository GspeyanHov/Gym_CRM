package org.epam.gymCrm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.epam.gymCrm.dao.TraineeDAO;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.service.TraineeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TraineeServiceImpl implements TraineeService {

    private final Logger logger = Logger.getLogger(TraineeServiceImpl.class.getName());
    private final TraineeDAO traineeDAO;

    @Override
    public void saveTrainee(Trainee trainee) {
        traineeDAO.create(trainee);
        logger.info("Trainee " + trainee + " saved");
    }

    @Override
    public List<Trainee> getAllTrainees() {
        logger.info("Trainee list loaded");
        return new ArrayList<>(traineeDAO.listAll());
    }

    @Override
    public Trainee getTraineeById(Integer id) {
        logger.info("Trainee " + id + " loaded");
        return traineeDAO.selectById(id);
    }

    @Override
    public void updateTrainee(Trainee trainee) {
        traineeDAO.update(trainee);
        logger.info("Trainee " + trainee + " updated");
    }

    @Override
    public void deleteTrainee(Integer id) {
        traineeDAO.delete(id);
        logger.info("Trainee " + id + " deleted");
    }
}
