package org.epam.gymCrm.service;

import java.util.List;
import org.epam.gymCrm.model.Training;
import org.epam.gymCrm.model.TrainingType;

public interface TrainingService {

    void createTraining(Training training);
    List<Training> getTrainingByType(TrainingType type);
}
