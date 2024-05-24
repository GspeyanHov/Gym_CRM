package org.epam.gymCrm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.epam.gymCrm.dao.TrainingDAO;
import org.epam.gymCrm.model.Training;
import org.epam.gymCrm.model.TrainingType;
import org.epam.gymCrm.service.TrainingService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final Logger logger = Logger.getLogger(TrainingServiceImpl.class.getName());
    private final TrainingDAO trainingDAO;

    @Override
    public void createTraining(Training training) {
        trainingDAO.create(training);
        logger.info("Created training: " + training);
    }

    @Override
    public List<Training> getTrainingByType(TrainingType type) {
        logger.info("Get trainings by type: " + type);
        return new ArrayList<>(trainingDAO.selectByType(type));
    }
}
