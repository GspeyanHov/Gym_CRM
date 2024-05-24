package org.epam.gymCrm.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.model.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class InMemoryStorageTest {

    private InMemoryStorage inMemoryStorage;

    @BeforeEach
    void setUp() {
        inMemoryStorage = new InMemoryStorage();
    }

    @Test
    void testTraineeMapInitialization() {
        Map<String, Trainee> traineeMap = inMemoryStorage.getTraineeMap();
        assertNotNull(traineeMap, "Trainee map should not be null");
        assertTrue(traineeMap.isEmpty(), "Trainee map should be empty initially");
    }

    @Test
    void testTrainerMapInitialization() {
        Map<String, Trainer> trainerMap = inMemoryStorage.getTrainerMap();
        assertNotNull(trainerMap, "Trainer map should not be null");
        assertTrue(trainerMap.isEmpty(), "Trainer map should be empty initially");
    }

    @Test
    void testTrainingMapInitialization() {
        Map<String, Training> trainingMap = inMemoryStorage.getTrainingMap();
        assertNotNull(trainingMap, "Training map should not be null");
        assertTrue(trainingMap.isEmpty(), "Training map should be empty initially");
    }

    @Test
    void testAddTrainee() {
        Trainee trainee = new Trainee();
        inMemoryStorage.getTraineeMap().put("trainee1", trainee);

        assertEquals(1, inMemoryStorage.getTraineeMap().size(), "Trainee map size should be 1");
        assertSame(trainee, inMemoryStorage.getTraineeMap().get("trainee1"), "Trainee should be retrievable by key");
    }

    @Test
    void testAddTrainer() {
        Trainer trainer = new Trainer();
        inMemoryStorage.getTrainerMap().put("trainer1", trainer);

        assertEquals(1, inMemoryStorage.getTrainerMap().size(), "Trainer map size should be 1");
        assertSame(trainer, inMemoryStorage.getTrainerMap().get("trainer1"), "Trainer should be retrievable by key");
    }

    @Test
    void testAddTraining() {
        Training training = new Training();
        inMemoryStorage.getTrainingMap().put("training1", training);

        assertEquals(1, inMemoryStorage.getTrainingMap().size(), "Training map size should be 1");
        assertSame(training, inMemoryStorage.getTrainingMap().get("training1"), "Training should be retrievable by key");
    }
}
