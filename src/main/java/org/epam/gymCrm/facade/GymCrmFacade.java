package org.epam.gymCrm.facade;

import java.util.List;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.model.Training;
import org.epam.gymCrm.model.TrainingType;

public interface GymCrmFacade {

    /**
     * trainee
     **/
    void saveTrainee(Trainee trainee);
    List<Trainee> getAllTrainees();
    Trainee getTraineeById(int id);
    void updateTrainee(Trainee trainee);
    void deleteTrainee(int id);
    /**
     * trainer
     **/
    void saveTrainer(Trainer trainer);
    void updateTrainer(Trainer trainer);
    Trainer getTrainerById(int id);
    /**
     * training
     **/
    void createTraining(Training training);
    List<Training> getTrainingByType(TrainingType type);

}