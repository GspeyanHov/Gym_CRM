package org.epam.gymCrm.storage;

import java.util.Arrays;
import java.util.List;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.model.Training;
import org.epam.gymCrm.service.TraineeService;
import org.epam.gymCrm.service.TrainerService;
import org.epam.gymCrm.service.TrainingService;
import org.epam.gymCrm.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class StorageInitializerTest {

    @Mock
    private TraineeService traineeService;

    @Mock
    private TrainerService trainerService;

    @Mock
    private TrainingService trainingService;

    @InjectMocks
    private StorageInitializer storageInitializer;

    private DataWrapper dataWrapper;

    @BeforeEach
    void setUp(){
        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        List<Trainee> trainees = Arrays.asList(trainee1, trainee2);

        Trainer trainer1 = new Trainer();
        Trainer trainer2 = new Trainer();
        List<Trainer> trainers = Arrays.asList(trainer1, trainer2);

        Training training1 = new Training();
        Training training2 = new Training();
        List<Training> trainings = Arrays.asList(training1, training2);

        dataWrapper = new DataWrapper();
        dataWrapper.setTrainees(trainees);
        dataWrapper.setTrainers(trainers);
        dataWrapper.setTrainings(trainings);

        ReflectionTestUtils.setField(storageInitializer, "dataFilePath", "test-path");
    }

    @Test
    void testInit(){
        try (MockedStatic<FileUtil> fileUtilMockedStatic = mockStatic(FileUtil.class)) {
            fileUtilMockedStatic.when(() -> FileUtil.readData(anyString(), eq(DataWrapper.class))).thenReturn(dataWrapper);

            storageInitializer.init();

            verify(traineeService, times(2)).saveTrainee(any(Trainee.class));
            verify(trainerService, times(2)).saveTrainer(any(Trainer.class));
            verify(trainingService, times(2)).createTraining(any(Training.class));
        }
    }
}
