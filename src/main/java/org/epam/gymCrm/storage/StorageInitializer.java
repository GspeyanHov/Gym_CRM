package org.epam.gymCrm.storage;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.model.Training;
import org.epam.gymCrm.service.TraineeService;
import org.epam.gymCrm.service.TrainerService;
import org.epam.gymCrm.service.TrainingService;
import org.epam.gymCrm.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class StorageInitializer implements BeanPostProcessor {

    @Value("${data.file.path}")
    private String dataFilePath;

    private final TraineeService traineeService;

    private final TrainerService trainerService;

    private final TrainingService trainingService;

    public StorageInitializer(TraineeService traineeService, TrainerService trainerService, TrainingService trainingService) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.trainingService = trainingService;
    }

    @PostConstruct
    public void init() {
        try {
            DataWrapper dataWrapper = FileUtil.readData(dataFilePath, DataWrapper.class);

            List<Trainee> trainees = dataWrapper.getTrainees();
            for (Trainee trainee : trainees) {
                traineeService.saveTrainee(trainee);
            }

            List<Trainer> trainers = dataWrapper.getTrainers();
            for (Trainer trainer : trainers) {
                trainerService.saveTrainer(trainer);
            }

            List<Training> trainings = dataWrapper.getTrainings();
            for (Training training : trainings) {
                trainingService.createTraining(training);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize storage from file", e);
        }
    }
}
