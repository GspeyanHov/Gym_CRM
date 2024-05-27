package org.epam.gymCrm.facade.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.epam.gymCrm.facade.GymCrmFacade;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.model.Training;
import org.epam.gymCrm.model.TrainingType;
import org.epam.gymCrm.service.TraineeService;
import org.epam.gymCrm.service.TrainerService;
import org.epam.gymCrm.service.TrainingService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GymCrmFacadeImpl implements GymCrmFacade {

    private final TraineeService traineeService;
    private final TrainerService trainerService;
    private final TrainingService trainingService;

    @Override
    public void saveTrainee(Trainee trainee) {
        traineeService.saveTrainee(trainee);
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return new ArrayList<>(traineeService.getAllTrainees());
    }

    @Override
    public Trainee getTraineeById(int id) {
        return traineeService.getTraineeById(id);
    }

    @Override
    public void updateTrainee(Trainee trainee) {
        traineeService.updateTrainee(trainee);
    }

    @Override
    public void deleteTrainee(int id) {
        traineeService.deleteTrainee(id);
    }

    @Override
    public void saveTrainer(Trainer trainer) {
        trainerService.saveTrainer(trainer);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        trainerService.updateTrainer(trainer);
    }

    @Override
    public Trainer getTrainerById(int id) {
        return trainerService.getTrainerById(id);
    }

    @Override
    public void createTraining(Training training) {
        trainingService.createTraining(training);
    }

    @Override
    public List<Training> getTrainingByType(TrainingType type) {
        return new ArrayList<>(trainingService.getTrainingByType(type));
    }
}
