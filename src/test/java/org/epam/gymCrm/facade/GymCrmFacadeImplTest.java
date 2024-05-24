package org.epam.gymCrm.facade;

import java.util.Collections;
import java.util.List;
import org.epam.gymCrm.facade.impl.GymCrmFacadeImpl;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.model.Training;
import org.epam.gymCrm.model.TrainingType;
import org.epam.gymCrm.service.TraineeService;
import org.epam.gymCrm.service.TrainerService;
import org.epam.gymCrm.service.TrainingService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class GymCrmFacadeImplTest {

    @Mock
    private TraineeService traineeService;

    @Mock
    private TrainerService trainerService;

    @Mock
    private TrainingService trainingService;

    @InjectMocks
    private GymCrmFacadeImpl gymCrmFacade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTrainee() {
        Trainee trainee = new Trainee();
        gymCrmFacade.saveTrainee(trainee);
        verify(traineeService, times(1)).saveTrainee(trainee);
    }

    @Test
    public void testGetAllTrainees() {
        Trainee trainee = new Trainee();
        when(traineeService.getAllTrainees()).thenReturn(Collections.singletonList(trainee));
        List<Trainee> result = gymCrmFacade.getAllTrainees();
        assertEquals(1, result.size());
        assertEquals(trainee, result.get(0));
    }

    @Test
    public void testGetTraineeById() {
        Trainee trainee = new Trainee();
        when(traineeService.getTraineeById(1)).thenReturn(trainee);
        Trainee result = gymCrmFacade.getTraineeById(1);
        assertEquals(trainee, result);
    }

    @Test
    public void testUpdateTrainee() {
        Trainee trainee = new Trainee();
        gymCrmFacade.updateTrainee(trainee);
        verify(traineeService, times(1)).updateTrainee(trainee);
    }

    @Test
    public void testDeleteTrainee() {
        gymCrmFacade.deleteTrainee(1);
        verify(traineeService, times(1)).deleteTrainee(1);
    }

    @Test
    public void testSaveTrainer() {
        Trainer trainer = new Trainer();
        gymCrmFacade.saveTrainer(trainer);
        verify(trainerService, times(1)).saveTrainer(trainer);
    }

    @Test
    public void testUpdateTrainer() {
        Trainer trainer = new Trainer();
        gymCrmFacade.updateTrainer(trainer);
        verify(trainerService, times(1)).updateTrainer(trainer);
    }

    @Test
    public void testGetTrainerById() {
        Trainer trainer = new Trainer();
        when(trainerService.getTrainerById(1)).thenReturn(trainer);
        Trainer result = gymCrmFacade.getTrainerById(1);
        assertEquals(trainer, result);
    }

    @Test
    public void testCreateTraining() {
        Training training = new Training();
        gymCrmFacade.createTraining(training);
        verify(trainingService, times(1)).createTraining(training);
    }

    @Test
    public void testGetTrainingByType() {
        Training training = new Training();
        when(trainingService.getTrainingByType(TrainingType.AEROBICS)).thenReturn(Collections.singletonList(training));
        List<Training> result = gymCrmFacade.getTrainingByType(TrainingType.AEROBICS);
        assertEquals(1, result.size());
        assertEquals(training, result.get(0));
    }
}
