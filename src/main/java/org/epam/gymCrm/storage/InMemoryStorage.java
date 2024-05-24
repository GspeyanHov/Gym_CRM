package org.epam.gymCrm.storage;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.epam.gymCrm.model.Trainee;
import org.epam.gymCrm.model.Trainer;
import org.epam.gymCrm.model.Training;

@Data
public class InMemoryStorage {

    private final Map<String, Trainee> traineeMap = new HashMap<>();
    private final Map<String, Trainer> trainerMap = new HashMap<>();
    private final Map<String, Training> trainingMap = new HashMap<>();

}
