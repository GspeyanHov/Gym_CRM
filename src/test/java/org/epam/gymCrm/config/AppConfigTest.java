package org.epam.gymCrm.config;

import java.lang.reflect.Field;
import org.epam.gymCrm.service.TraineeService;
import org.epam.gymCrm.service.TrainerService;
import org.epam.gymCrm.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(value = {SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = AppConfig.class)
public class AppConfigTest {

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private TrainingService trainingService;

    @Test
    public void testServicesNotNull() {
        assertNotNull(traineeService);
        assertNotNull(trainerService);
        assertNotNull(trainingService);
    }
}
