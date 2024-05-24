package org.epam.gymCrm.service;

import java.util.List;
import org.epam.gymCrm.model.Trainee;

public interface TraineeService {

    void saveTrainee(Trainee trainee);
    List<Trainee> getAllTrainees();
    Trainee getTraineeById(Integer id);
    void updateTrainee(Trainee trainee);
    void deleteTrainee(Integer id);
}
